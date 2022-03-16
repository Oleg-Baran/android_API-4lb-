package com.example.colorswitcher

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.colorswitcher.data.TestApiService
import com.example.colorswitcher.data.model.User
import com.example.colorswitcher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding

    @SuppressLint("SetTextI18n")
    fun displayUser(user: User) {
        Log.d("API", user.login)
        Log.d("API", user.token)
        Log.d("API", "${user.location.country}, ${user.location.city}")

        bindingClass.tvLogin.text = ("Login: ${user.login}")
        bindingClass.tvLocation.text = ("Location: ${user.location.country}, ${user.location.city}")
        bindingClass.tvToken.text = ("Token: ${user.token}")
    }
    fun displayError() {
        Log.d("API", "error loading data")
        Toast.makeText(
            this, "Failed load data",
            Toast.LENGTH_LONG).show()
    }

    private fun loadData() {
        Log.d("API", "loadData")
        val service = TestApiService()
        service.getLocalUser(object : TestApiService.UserCallback {
            override fun onSuccess(user: User) {
                displayUser(user)
            }
            override fun onFailure() {
                displayError()
            }
        }
        )
    }

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        bindingClass.button.setOnClickListener { loadData() }
        }
    }