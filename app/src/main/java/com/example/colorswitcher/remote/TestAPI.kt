package com.example.colorswitcher.data

import com.example.colorswitcher.data.model.User
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

interface TestApi {
    @GET("b/6231fdb80618276743788d11")
    fun getLocalUser(@Header("secret-key") secretKey: String): Call<User>
}