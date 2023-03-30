package co.develhope.meteoapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       setNavigationGraph()
        binding.bottomNavBar.setOnClickListener {
            var today = binding.bottomNavBar.menu.findItem(R.id.specificDayFragment).title.toString()
            when(today){
                getString(R.string.oggi_name_menu) -> Toast.makeText(this, "today", Toast.LENGTH_LONG).show()
                else -> Toast.makeText(this, "tomorrow", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setNavigationGraph() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.navigation)
        navController.graph = navGraph


        setupWithNavController(binding.bottomNavBar,navController)
    }
}



