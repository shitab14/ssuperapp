package smir.shitab.shitabssuperapp.pages.homelanding

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.base.activity.BaseActivity
import smir.shitab.shitabssuperapp.databinding.ActivityHomeLandingBinding
import smir.shitab.shitabssuperapp.pages.homelanding.homepage.HomeLandingFragment
import smir.shitab.shitabssuperapp.pages.homelanding.settingspage.SettingsFragment

class HomeLandingActivity : BaseActivity<ActivityHomeLandingBinding>() {

//    private lateinit var binding: ActivityHomeLandingBinding
    private lateinit var homeLandingFragment: HomeLandingFragment
    private lateinit var settingsFragment: SettingsFragment

    private lateinit var navController: NavController

    override val layoutResourceId: Int
        get() = R.layout.activity_home_landing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // View Binding
//        binding = ActivityHomeLandingBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        // Fragments
        homeLandingFragment = HomeLandingFragment()
        settingsFragment = SettingsFragment()

        // old way
/*
        setCurrentFragment(homeLandingFragment)
*/
        // new way
        val navHostFragment: NavHostFragment = dataBinding.homeNavHostFragment.getFragment() //supportFragmentManager.findFragmentById(R.id.homeNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController // Navigation.findNavController(this, R.id.homeNavHostFragment)

        // Bottom Sheet
        setupBottomSheet(navController)

    }

    private fun setupBottomSheet(navController: NavController) {
        dataBinding/*binding*/.bottomNavigationView.setOnItemSelectedListener {
            /// old way
/*            when(it.itemId){
                R.id.home-> setCurrentFragment(homeLandingFragment)
                R.id.settingsFragment-> setCurrentFragment(settingsFragment)
            }
*/

            /// new way
            setCurrentFragment(it.itemId)
            true
        }
    }

    // old way
/*
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flHomeLanding,fragment)
            commit()
        }
    }
*/

    private fun setCurrentFragment(fragmentId: Int) {
        if (fragmentId != navController.currentDestination?.id) {
            navController.navigate(fragmentId)
            dataBinding/*binding*/.bottomNavigationView.selectedItemId = fragmentId
        }

    }


}