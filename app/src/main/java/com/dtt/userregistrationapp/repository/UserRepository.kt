package com.dtt.userregistrationapp.repository

import com.dtt.userregistrationapp.data.dao.UserDao
import com.dtt.userregistrationapp.data.entity.User

class UserRepository(private val userDao: UserDao) {

    suspend fun register(user: User) = userDao.insert(user)

    suspend fun login(emailOrMobile: String) = userDao.getUser(emailOrMobile)
}