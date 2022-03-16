package com.example.colorswitcher.data

import com.example.colorswitcher.data.model.User
import okhttp3.OkHttpClient
import retrofit2.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestApiService() {

    interface UserCallback {
        fun onSuccess(user: User)
        fun onFailure()
    }

}


