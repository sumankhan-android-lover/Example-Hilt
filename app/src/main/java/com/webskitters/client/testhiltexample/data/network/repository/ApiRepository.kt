package com.webskitters.client.testhiltexample.data.network.repository

import android.content.SharedPreferences
import com.webskitters.client.testhiltexample.app.UserPreferences
import com.webskitters.client.testhiltexample.data.model.LoginData.LoginModel
import com.webskitters.client.testhiltexample.data.network.ApiService
import org.json.JSONObject
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val api: ApiService,
    private val appPrefs: SharedPreferences
) : BaseRepository(api){

    private val key by lazy {
        appPrefs.getInt("status",0)
    }

    suspend fun login(
        data: LoginModel
    ) = safeApiCall {
        println("i am key $key")
        api.login(data)
    }
}