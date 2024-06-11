package com.tienanh.anhntph37315_assignment.database.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tienanh.anhntph37315_assignment.database.repository.SaveUserRepository
import com.tienanh.anhntph37315_assignment.database.viewModel.SaveUserViewModel

class SaveUserFactory(private val saveUserRepository: SaveUserRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SaveUserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SaveUserViewModel(saveUserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}