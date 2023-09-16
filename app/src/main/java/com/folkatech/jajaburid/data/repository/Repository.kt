package com.folkatech.jajaburid.data.repository

import com.folkatech.jajaburid.data.network.ApiService
import com.folkatech.jajaburid.data.network.FoodResponseItem
import com.folkatech.jajaburid.data.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(private val apiService: ApiService){

    //Get the response data from network and integrate it with flow coroutine
    fun getFood(): Flow<Resource<List<FoodResponseItem?>>> = flow {
        val response = apiService.getFood()
        if(response != null){
            emit(Resource.Success(response))
        } else {
            emit(Resource.Error("Error"))
        }
    }.flowOn(Dispatchers.IO)
}