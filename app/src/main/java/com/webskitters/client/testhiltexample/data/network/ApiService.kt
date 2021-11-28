package com.webskitters.client.testhiltexample.data.network

import com.webskitters.client.testhiltexample.data.model.LoginData.LoginData
import com.webskitters.client.testhiltexample.data.model.LoginData.LoginModel
import com.webskitters.client.testhiltexample.utils.Constants
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST(Constants.API_END_POINT.App_SignIn)
    suspend fun login(
        //@Header("Authorizationkey") auth:String,
        @Body model : LoginModel
/*        @Field("username") username: String,
        @Field("password") password: String,
        @Field("device_id") device_id: String*/
    ): LoginData
}
