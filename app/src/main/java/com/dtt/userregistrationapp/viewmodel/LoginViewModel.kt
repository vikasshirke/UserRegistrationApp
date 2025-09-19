package com.dtt.userregistrationapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.dtt.userregistrationapp.data.database.AppDataBase
import com.dtt.userregistrationapp.repository.UserRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: UserRepository

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    init {
        val dao = AppDataBase.getDatabase(application).userDao()
        repo = UserRepository(dao)
    }

    fun login(emailOrMobile: String, password: String){
        viewModelScope.launch {
            val user = repo.login(emailOrMobile)
            val success = user?.password == password
            _loginResult.postValue(success)
        }
    }
}