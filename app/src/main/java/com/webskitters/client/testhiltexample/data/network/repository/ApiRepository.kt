package com.webskitters.client.testhiltexample.data.network.repository

import com.webskitters.client.testhiltexample.app.UserPreferences
import com.webskitters.client.testhiltexample.data.model.LoginData.LoginModel
import com.webskitters.client.testhiltexample.data.network.ApiService
import org.json.JSONObject
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val api: ApiService,
    private val preferences: UserPreferences
) : BaseRepository(api){

    suspend fun login(
        data: LoginModel
    ) = safeApiCall {
        api.login(data/*.username,data.password,data.device_id*/)
    }
}