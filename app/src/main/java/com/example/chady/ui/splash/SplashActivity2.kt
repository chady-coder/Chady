package com.example.chady.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.chady.R
import com.example.chady.ui.main.MainActivity

class SplashActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(MainActivity.getStartIntent(this))
            finish()
        }, 1000)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}


