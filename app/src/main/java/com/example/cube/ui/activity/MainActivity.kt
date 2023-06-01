package com.example.cube.ui.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.cube.R
import com.example.cube.databinding.ActivityMainBinding
import com.example.cube.ui.fragments._notifycation.brodcast.setAlarmBroadcast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
        notification()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

    private fun notification() {
//        setAlarmService(applicationContext)
//        setAlarmBroadcast(applicationContext)
    }
}