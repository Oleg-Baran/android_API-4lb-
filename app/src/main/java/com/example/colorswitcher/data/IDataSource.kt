package com.example.colorswitcher.data

import com.example.colorswitcher.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

interface IDataSource {

    companion object {
        private const val secretKey : String = "\$2b\$10\$ePmczRLzUtl7VcsHJZH1HuAeTy90sdys1kOdDiCUasBQcOxQZWiJO"
    }

    private val retrofit: Retrofit
        get() = RetrofitApiHelper.getRetrofitInstance()
    private val api: TestApi
        get() = retrofit.create(TestApi::class.java)

    fun getLocalUser(callback: TestApiService.UserCallback) {
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

}