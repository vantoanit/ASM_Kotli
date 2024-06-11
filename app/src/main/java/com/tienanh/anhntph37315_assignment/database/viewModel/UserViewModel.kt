package com.tienanh.anhntph37315_assignment.database.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tienanh.anhntph37315_assignment.database.entities.Users
import com.tienanh.anhntph37315_assignment.database.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun userSignIn(email: String, password: String)
            : LiveData<List<Users>> =
        userRepository.userSignIn(email, password)

    fun userSignUp(users: Users) {
        viewModelScope.launch {
            userRepository.userSignUp(users)
        }
    }

    fun getUser(email: String): LiveData<Users> = userRepository.getUser(email)
}