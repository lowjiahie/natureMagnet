package com.example.naturemagnet

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.naturemagnet.dao.PrefManager
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.ActivityMainBinding
import com.example.naturemagnet.datagenerator.SampleDataGenerator
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    private lateinit var db: NatureMagnetDB
    private lateinit var prefManager: PrefManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        db = NatureMagnetDB.getInstance(this)!!
        prefManager = PrefManager(this)!!
        prefManager.setId(2)
//        db.customerDao().insertCustomer(SampleDataGenerator.getCustomer())
        Log.e("MainActivity", db.activityDao().getAll().toString())
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.awarenessMainFragment,
                R.id.eventMainFragment
            ), binding.drawerLayout
        )
        navController = findNavController(R.id.hostFragment)
        binding.apply {
            //toolbar
            toolbar.setupWithNavController(navController, appBarConfiguration)

            //drawer
            navView.setupWithNavController(navController)

            //bottomNav
            bottomNavigation.setupWithNavController(navController)
        }

        //hide or show the bottom nav in specific fragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                //this ID refer to the id that inside the bottom nav menu
                R.id.homeFragment -> showBottomNav()
                R.id.awarenessMainFragment -> showBottomNav()
                R.id.eventMainFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }

    }

    private fun showBottomNav(){
        binding.bottomNavigation.visibility = View.VISIBLE

    }

    private fun hideBottomNav(){
        binding.bottomNavigation.visibility = View.GONE
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean{
//        return toggle.onOptionsItemSelected(item)
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }


}