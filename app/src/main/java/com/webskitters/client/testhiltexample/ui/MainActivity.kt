package com.webskitters.client.testhiltexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.webskitters.client.testhiltexample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.simplifiedcoding.data.network.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var deviceId:String
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindUI()
    }

    private fun bindUI() {
        deviceId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)

        viewModel.response.observe(this){
           // binding.progressbar.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        Log.e(TAG, "bindUI: ".plus(it) )
                        startActivity(Intent(this@MainActivity,HomeActivity::class.java))
                        this@MainActivity.finish()
                    }
                }
                is Resource.Failure ->{
                    println("error - $it")
                }
            }
        }

        binding.login.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            viewModel.login(username, password, deviceId)
        }
    }
}