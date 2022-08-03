package com.example.emovie.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.emovie.ui.home.HomeActivity
import com.example.emovie.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler(mainLooper).postDelayed(Runnable { //This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, 3000)
    }
}