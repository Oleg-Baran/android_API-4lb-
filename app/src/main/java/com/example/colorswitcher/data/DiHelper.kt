package com.example.colorswitcher.data


object DiHelper {
    fun provideTestApi(): TestApi =
        RetrofitApiHelper.getRetrofitInstance().create(TestApi::class.java)

    fun provideIDataSource(): IDataSource = TestApiService()

    fun provideMainPresenter(): MainContract.Presenter = MainPresenter()

}