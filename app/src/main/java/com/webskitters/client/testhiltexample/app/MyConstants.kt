package com.webskitters.client.testhiltexample.app

class MyConstants {

    object COMMON_CONST {
        const val DEVICE_TYPE = "android"
        const val USER_TYPE = "client"
        const val EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

        const val BASE_URL = "https://cine.cinemagicx.com/"                          //development URL
        const val TOKEN = "85e14c4b09be236595o7f7a989caee0299a52de7"

    }

    object API_END_POINT {
        const val App_SignIn = "api/Login"
    }

    object DATABASE_CONST {
        const val DATABASE_NAME = "my_test_db"
    }



}