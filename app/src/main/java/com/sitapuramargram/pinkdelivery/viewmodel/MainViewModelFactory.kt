package com.sitapuramargram.pinkdelivery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sitapuramargram.pinkdelivery.repositories.ItemRepository

class MainViewModelFactory(private val repository: ItemRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}