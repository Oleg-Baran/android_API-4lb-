package com.example.colorswitcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.colorswitcher.data.MainContract.Presenter
import com.example.colorswitcher.data.model.User
import com.example.colorswitcher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    private lateinit var presenter : Presenter


    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        presenter.displayUser(User())

        presenter.displayError(this)

        bindingClass.button.setOnClickListener { presenter.loadData(this) }
        }
    }