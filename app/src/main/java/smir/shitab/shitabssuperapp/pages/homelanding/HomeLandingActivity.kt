package smir.shitab.shitabssuperapp.pages.homelanding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.pages.homelanding.homepage.HomeFragment
import smir.shitab.shitabssuperapp.pages.homelanding.settingspage.SettingsFragment

class HomeLandingActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_landing)

        val homeFragment = HomeFragment()
        val settingsFragment = SettingsFragment()

        setCurrentFragment(homeFragment)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(homeFragment)
                R.id.settings->setCurrentFragment(settingsFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flHomeLanding,fragment)
            commit()
        }
    }

}