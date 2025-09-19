package ug.go.ugpass.userregistrationlivedataapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ug.go.ugpass.userregistrationlivedataapp.data.database.AppDataBase
import ug.go.ugpass.userregistrationlivedataapp.data.entity.User
import ug.go.ugpass.userregistrationlivedataapp.repository.UserRepository

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