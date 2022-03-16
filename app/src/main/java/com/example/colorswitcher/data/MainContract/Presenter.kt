package com.example.colorswitcher.data.MainContract

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.colorswitcher.data.IDataSource
import com.example.colorswitcher.data.TestApiService
import com.example.colorswitcher.data.model.User
import com.example.colorswitcher.databinding.ActivityMainBinding

interface Presenter {
    var bindingClass : ActivityMainBinding

    var dataSource : IDataSource

    @SuppressLint("SetTextI18n")
    fun displayUser(user: User) {
        Log.d("API", user.login)
        Log.d("API", user.token)
        Log.d("API", "${user.location.country}, ${user.location.city}")

        bindingClass.tvLogin.text = ("Login: ${user.login}")
        bindingClass.tvLocation.text = ("Location: ${user.location.country}, ${user.location.city}")
        bindingClass.tvToken.text = ("Token: ${user.token}")
    }
    fun displayError(ctx : Context) {
        Log.d("API", "error loading data")
        Toast.makeText(
            ctx, "Failed load data",
            Toast.LENGTH_LONG).show()
    }

    fun loadData(ctx : Context) {
        Log.d("API", "loadData")
        val service = dataSource
        service.getLocalUser(object : TestApiService.UserCallback {
            override fun onSuccess(user: User) {
                displayUser(user)
            }
            override fun onFailure() {
                displayError(ctx)
            }
        }
        )
    }
}