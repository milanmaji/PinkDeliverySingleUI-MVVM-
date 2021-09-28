package com.sitapuramargram.pinkdelivery.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.volley.Response
import com.sitapuramargram.pinkdelivery.model.Data
import com.sitapuramargram.pinkdelivery.repositories.ApiResponse
import com.sitapuramargram.pinkdelivery.repositories.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: ItemRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProductData("3","","1","mob")
        }



    }

    val dataList: LiveData<ApiResponse<List<Data>>>
        get() = repository.dataList

}