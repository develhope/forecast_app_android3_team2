package co.develhope.meteoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // replaceFragment(HomePageFragment())
        setNavigationGraph()
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.HomePage -> replaceFragment(HomePageFragment())
                R.id.Oggi -> replaceFragment(SpecificDayFragment())
                R.id.Domani -> replaceFragment(SpecificDayFragment())
                R.id.Search -> replaceFragment(SearchFragment())
                else->{}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainLayout,fragment)
        fragmentTransaction.commit()
    }
    private fun setNavigationGraph() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.navigation)
        navController.graph = navGraph


    }
}