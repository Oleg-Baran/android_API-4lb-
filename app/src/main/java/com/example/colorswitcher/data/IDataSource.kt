package com.example.colorswitcher.data

import com.example.colorswitcher.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

interface IDataSource {

    fun getLocalUser(
        onResult: (User) -> Unit,
        onError: (Throwable) -> Unit,
    )

}