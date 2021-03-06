
package com.basketwithapp.api

import com.basketwithapp.api.SharedPreferencesManager
import com.basketwithapp.common.Constants
import okhttp3.Interceptor
import okhttp3.Response

class BasketWithInterceptor: Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        var token =
            SharedPreferencesManager.getStringValue(
                Constants.TOKEN
            )
        var request = chain.request()

            token= SharedPreferencesManager.getStringValue(Constants.TOKEN)
            request = request?.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()


        return chain.proceed(request)

    }
}