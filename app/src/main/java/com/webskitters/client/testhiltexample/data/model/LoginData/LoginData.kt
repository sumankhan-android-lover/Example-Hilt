package com.webskitters.client.testhiltexample.data.model.LoginData

data class LoginData(
    val code: Int,
    val `data`: List<Login>,
    val notification: List<Any>,
    val status: String
)