package com.example.colorswitcher.data

import com.example.colorswitcher.data.model.User
import okhttp3.OkHttpClient
import retrofit2.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestApiService : IDataSource {

    private  val secretKey : String = "\$2b\$10\$ePmczRLzUtl7VcsHJZH1HuAeTy90sdys1kOdDiCUasBQcOxQZWiJO"


    private val api: TestApi = DiHelper.provideTestApi()

    override fun getLocalUser(
        onResult: (User) -> Unit,
        onError: (Throwable) -> Unit,
    ) {
        api.getLocalUser(secretKey).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val body = response.body()
                if (response.code() == 200 && body != null)
                    onResult(body)
                else
                    onError(Exception("Bad response"))
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onError(t)
            }
        })
    }

}


