package smir.shitab.shitabssuperapp.pages.homelanding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.databinding.ActivityHomeLandingBinding
import smir.shitab.shitabssuperapp.pages.homelanding.homepage.HomeLandingFragment
import smir.shitab.shitabssuperapp.pages.homelanding.settingspage.SettingsFragment

class HomeLandingActivity : AppCompatActivity() {

//    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var binding: ActivityHomeLandingBinding
    private lateinit var homeLandingFragment: HomeLandingFragment
    private lateinit var settingsFragment: SettingsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // View Binding
        binding = ActivityHomeLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fragments
        homeLandingFragment = HomeLandingFragment()
        settingsFragment = SettingsFragment()
        setCurrentFragment(homeLandingFragment)

//        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        // Bottom Sheet
        setupBottomSheet()

    }

    private fun setupBottomSheet() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(homeLandingFragment)
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