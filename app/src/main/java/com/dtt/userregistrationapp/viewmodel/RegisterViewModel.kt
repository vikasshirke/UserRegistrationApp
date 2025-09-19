package com.dtt.userregistrationapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.dtt.userregistrationapp.data.database.AppDataBase
import com.dtt.userregistrationapp.data.entity.User
import com.dtt.userregistrationapp.repository.UserRepository

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: UserRepository

    private val _registrationStatus  = MutableLiveData<Boolean>()
    val registrationStatus: LiveData<Boolean> = _registrationStatus

    init {
        val dao = AppDataBase.getDatabase(application).userDao()
        repo = UserRepository(dao)
    }

    fun register(user: User){
        viewModelScope.launch {
            repo.register(user)
            _registrationStatus.postValue(true)        }
    }

}