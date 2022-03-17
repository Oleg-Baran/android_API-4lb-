package com.example.colorswitcher.data

import android.util.Log
import com.example.colorswitcher.data.MainContract

class MainPresenter : MainContract.Presenter {
    private var view: MainContract.View? = null

    private val dataSource: IDataSource = DiHelper.provideIDataSource()

    override fun loadData() {
        Log.d("API", "loadData")
        dataSource.getLocalUser(
            onResult = {
                view?.displayUser(it)
            },
            onError = {
                view?.displayError(it)
            },
        )
    }

    override fun registerView(view: MainContract.View) {
        this.view = view
    }

    override fun unregisterView(view: MainContract.View) {
        this.view = null
    }

}