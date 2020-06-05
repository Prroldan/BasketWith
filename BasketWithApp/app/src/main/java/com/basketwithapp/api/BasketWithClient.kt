package com.basketwithapp.api

import com.basketwithapp.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BasketWithClient {
    private val basketWithService: BasketWithService
    private val retrofit: Retrofit

    init {

        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(BasketWithInterceptor())

        var logging : HttpLoggingInterceptor = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val cliente = okHttpClientBuilder.addInterceptor(logging).build()


        retrofit = Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(cliente)
            .build()



        basketWithService = retrofit.create(BasketWithService::class.java)
    }

    fun getBasketWithService() = basketWithService

}