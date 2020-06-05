package com.basketwithapp

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.basketwithapp.common.Constants
import com.basketwithapp.common.MyApp
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val fab: View = findViewById(R.id.floatingActionButton2)
        fab.setOnClickListener { view ->
            if (navView.selectedItemId == R.id.navigation_home ) {
                val intent = Intent(MyApp.context, CreateFreeEventActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                MyApp.context?.let { ContextCompat.startActivity(it, intent, null) }
            } else if(navView.selectedItemId == R.id.navigation_dashboard ){
                val intent = Intent(MyApp.context, CreatePayEventActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                MyApp.context?.let { ContextCompat.startActivity(it, intent, null) }
            }

        }

        if(navView.selectedItemId == R.id.navigation_notifications){
            fab.visibility = GONE
        }
    }
}

