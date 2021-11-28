package com.webskitters.client.testhiltexample.utils

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.webskitters.client.testhiltexample.ui.MainActivity
import net.simplifiedcoding.data.network.Resource

fun Fragment.handleApiError(
    failure: Resource.Failure,
    retry: (() -> Unit)? = null
) {
    when {
        failure.isNetworkError -> requireView().snackbar(
            "Please check your internet connection",
            retry
        )
       /* failure.errorCode == 401 -> {
            if (this is MainActivity::class.java) {
                requireView().snackbar("You've entered incorrect email or password")
            } else {
               // logout()
            }
        }*/
        else -> {
            val error = failure.errorBody?.string().toString()
            requireView().snackbar(error)
        }
    }
}

fun View.snackbar(message: String, action: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    action?.let {
        snackbar.setAction("Retry") {
            it()
        }
    }
    snackbar.show()
}