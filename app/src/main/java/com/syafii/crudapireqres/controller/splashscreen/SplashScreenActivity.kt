package com.syafii.crudapireqres.controller.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syafii.crudapireqres.R
import com.syafii.crudapireqres.controller.homepage.MainActivity
import com.syafii.crudapireqres.util.openActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Timer().schedule(3000){
            openActivity(MainActivity::class.java)
            finish()
        }
    }
}