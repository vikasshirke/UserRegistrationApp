package ug.go.ugpass.userregistrationlivedataapp.repository

import ug.go.ugpass.userregistrationlivedataapp.data.dao.UserDao
import ug.go.ugpass.userregistrationlivedataapp.data.entity.User

class UserRepository(private val userDao: UserDao) {

    suspend fun register(user: User) = userDao.insert(user)

    suspend fun login(emailOrMobile: String) = userDao.getUser(emailOrMobile)
}