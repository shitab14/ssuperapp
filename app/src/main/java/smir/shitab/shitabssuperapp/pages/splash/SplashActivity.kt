package smir.shitab.shitabssuperapp.pages.splash

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.common.Util
import smir.shitab.shitabssuperapp.pages.homelanding.HomeLandingActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private var context: Context? = null
    private var splashViewModel: SplashViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@SplashActivity
        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        splashViewModel?.goToHomePage(context as SplashActivity, HomeLandingActivity::class.java)
        /*
        GlobalScope.launch(Dispatchers.Main) {
            delay(2000L)
            Util.goToNextActivity(context as SplashActivity, HomeLandingActivity::class.java)
        }
        */

    }



}