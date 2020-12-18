package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        //Setting support action bar as toolbar
        setSupportActionBar(binding.toolbar)

        val navController=this.findNavController(R.id.my_nav_host_fragment)
        //Setup Nav controller with toolbar
        NavigationUI.setupActionBarWithNavController(this,navController)
        appBarConfiguration= AppBarConfiguration(navController.graph)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.shoeListFragment) {
                supportActionBar?.setHomeButtonEnabled(false)
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.my_nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
    }

}
