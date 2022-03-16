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
    private var api: TestApi
    private val secretKey : String = "\$2b\$10\$ePmczRLzUtl7VcsHJZH1HuAeTy90sdys1kOdDiCUasBQcOxQZWiJO"

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(TestApi::class.java)
    }

    fun getLocalUser(callback: UserCallback) {
        api.getLocalUser(secretKey).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == 200 && response.body() != null)
                    callback.onSuccess(response.body()!!)
                else
                    callback.onFailure()
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                callback.onFailure()
            }
        })
    }

    interface UserCallback {
        fun onSuccess(user: User)
        fun onFailure()
    }
}


