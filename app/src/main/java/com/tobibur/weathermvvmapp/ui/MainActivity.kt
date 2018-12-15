package com.tobibur.weathermvvmapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.tobibur.weathermvvmapp.R
import com.tobibur.weathermvvmapp.ui.settings.SettingsFragment
import com.tobibur.weathermvvmapp.helpers.FragmentTools
import com.tobibur.weathermvvmapp.helpers.info
import com.tobibur.weathermvvmapp.ui.weather.current.CurrentWeatherFragment
import com.tobibur.weathermvvmapp.ui.weather.future.list.FutureListWeatherFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fragmentHome()

        bottom_nav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.currentWeatherFragment -> {
                    fragmentHome()
                    this.info { "currentWeatherFragment" }
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.futureListWeatherFragment -> {
                    toolbar.title = "FutureListWeatherFragment"
                    val futureListWeatherFragment = FutureListWeatherFragment.newInstance()
                    openFragment(futureListWeatherFragment)
                    this.info { "futureListWeatherFragment" }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.settingsFragment -> {
                    toolbar.title = "SettingsFragment"
                    val settingsFragment = SettingsFragment.newInstance()
                    openFragment(settingsFragment)
                    this.info { "settingsFragment" }
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun fragmentHome() {
        toolbar.title = "CurrentWeatherFragment"
        val currentWeatherFragment = CurrentWeatherFragment.newInstance()
        openFragment(currentWeatherFragment)
    }

    private fun openFragment(fragment: Fragment) {
        FragmentTools.replaceFragment(fragment, supportFragmentManager, R.id.nav_host_fragment)
    }

    override fun onBackPressed() {
        val backStackEntryCount = supportFragmentManager.backStackEntryCount
        Log.d("test", backStackEntryCount.toString())
        if (backStackEntryCount == 1) {
            finish()
        } else {
            if (backStackEntryCount > 1) {
                supportFragmentManager.popBackStack()
            } else {
                super.onBackPressed()
            }
        }
    }
}
