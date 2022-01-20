package smir.shitab.shitabssuperapp.pages.splash

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import smir.shitab.shitabssuperapp.common.Util

class SplashViewModel : ViewModel() {

    fun goToHomePage(context: Context, activityClass: Class<out Activity?>?) = run {
        viewModelScope.launch {
            delay(2000L)
            Util.goToNextActivity(context, activityClass)
        }
    }

}