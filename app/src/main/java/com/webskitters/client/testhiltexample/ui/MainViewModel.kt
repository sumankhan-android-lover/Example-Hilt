package com.webskitters.client.testhiltexample.ui

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.webskitters.client.testhiltexample.data.model.LoginData.LoginData
import com.webskitters.client.testhiltexample.data.model.LoginData.LoginModel
import com.webskitters.client.testhiltexample.data.network.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.simplifiedcoding.data.network.Resource
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val appPrefs: SharedPreferences
):ViewModel() {
    private val loginResponse : MutableLiveData<Resource<LoginData>> = MutableLiveData()

    val response : LiveData<Resource<LoginData>>
        get() = loginResponse

    fun login(username:String, password:String, id:String) = viewModelScope.launch{
        appPrefs.edit()
            .putString("abc","abc")
            .putBoolean("login",true)
            .putInt("status",1).apply()
//        val data = JSONObject()
//        data.put("username",username)
//        data.put("password",password)
//        data.put("device_id",id)
        val model = LoginModel(username,password,id)
        loginResponse.value = repository.login(model)
    }

}