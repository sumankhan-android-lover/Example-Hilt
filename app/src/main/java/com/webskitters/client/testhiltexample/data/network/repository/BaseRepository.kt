package com.webskitters.client.testhiltexample.data.network.repository

import com.webskitters.client.testhiltexample.data.network.ApiService
import net.simplifiedcoding.data.network.SafeApiCall

abstract class BaseRepository(private val api: ApiService) : SafeApiCall