package com.tienanh.anhntph37315_assignment.database.repository

import androidx.lifecycle.LiveData
import com.tienanh.anhntph37315_assignment.database.dao.UserDao
import com.tienanh.anhntph37315_assignment.database.entities.Users

class UserRepository(private val userDao: UserDao) {
    fun userSignIn(email: String, password: String): LiveData<List<Users>> =
        userDao.userSignIn(email, password)

    suspend fun userSignUp(users: Users) {
        userDao.userSignUp(users)
    }

    fun getUser(email: String): LiveData<Users> = userDao.getUser(email)
}