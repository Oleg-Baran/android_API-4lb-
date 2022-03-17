package com.example.colorswitcher

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.colorswitcher.data.DiHelper
import com.example.colorswitcher.data.MainContract
import com.example.colorswitcher.data.model.User
import com.example.colorswitcher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var bindingClass : ActivityMainBinding
    private val presenter = DiHelper.provideMainPresenter()

    @SuppressLint("SetTextI18n")
    override fun displayUser(user: User) {
        Log.d("API", user.login)
        Log.d("API", user.token)
        Log.d("API", "${user.location.country}, ${user.location.city}")

        bindingClass.tvLogin.text = ("Login: ${user.login}")
        bindingClass.tvLocation.text = ("Location: ${user.location.country}, ${user.location.city}")
        bindingClass.tvToken.text = ("Token: ${user.token}")
    }

    override fun displayError(throwable: Throwable) {
        throwable.printStackTrace()
        Toast.makeText(
            this, throwable.message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        presenter.registerView(this)

        bindingClass.button.setOnClickListener { presenter.loadData() }
        }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unregisterView(this)
    }
    }