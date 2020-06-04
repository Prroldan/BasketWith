package com.basketwithapp.api

import android.content.Context
import android.content.SharedPreferences
import com.basketwithapp.common.Constants
import com.basketwithapp.common.MyApp


class SharedPreferencesManager private constructor(ctx: Context) {
    private val ctx: Context? = null

    companion object {
        private val sharedPreferences: SharedPreferences?
            private get() = MyApp.context?.getSharedPreferences(
                Constants.APP_SETTINGS,
                Context.MODE_PRIVATE
            )

        fun setStringValue(dataLabel: String?, dataValue: String?) {
            val editor =
                sharedPreferences?.edit()
            editor?.putString(dataLabel, dataValue)
            editor?.commit()
        }

        fun getStringValue(dataLabel: String?): String? {
            return sharedPreferences
                ?.getString(dataLabel, null)
        }
    }
}