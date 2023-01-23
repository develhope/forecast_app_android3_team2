package co.develhope.meteoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.databinding.ActivityMainBinding
import co.develhope.meteoapp.homepage.HomePage

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomePage())

        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.HomePage -> replaceFragment(HomePage())
                R.id.Oggi -> replaceFragment(SpecificDay())
                R.id.Domani -> replaceFragment(tomorrow())
                R.id.Search -> replaceFragment(search())
                else->{}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}