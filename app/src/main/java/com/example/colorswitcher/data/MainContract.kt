package com.example.colorswitcher.data

import com.example.colorswitcher.data.model.User

interface MainContract {

    interface View{
        fun displayUser(user: User)
        fun displayError(throwable: Throwable)
    }

    interface Presenter {
        fun loadData()
        fun registerView(view: View)
        fun unregisterView(view: View)
    }
}