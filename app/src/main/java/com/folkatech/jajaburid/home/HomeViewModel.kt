package com.folkatech.jajaburid.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.folkatech.jajaburid.data.repository.Repository
import com.folkatech.jajaburid.data.network.FoodResponseItem
import com.folkatech.jajaburid.data.network.Resource

class HomeViewModel(private val repository: Repository): ViewModel() {
    val data: LiveData<Resource<List<FoodResponseItem?>>> = liveData {
        emit(Resource.Loading())
        emitSource(repository.getFood().asLiveData())
    }
}