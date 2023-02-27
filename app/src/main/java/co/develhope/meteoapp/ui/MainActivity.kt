package co.develhope.meteoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.ActivityMainBinding
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch
import java.time.OffsetDateTime
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomePageFragment())

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.HomePage -> replaceFragment(HomePageFragment())
                R.id.Oggi -> replaceFragment(SpecificDayFragment())
                R.id.Domani -> replaceFragment(SpecificDayFragment())
                R.id.Search -> replaceFragment(SearchFragment())
                else -> {}
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}