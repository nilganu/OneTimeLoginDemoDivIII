package com.cahrusat.onetimelogindiviii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var preference=getSharedPreferences("MyPref", MODE_PRIVATE)
        var str=preference.getString("user","wrong")
        Handler().postDelayed(Runnable {
           if(str.equals("wrong")) {
               var intent = Intent(applicationContext, MainActivity::class.java)
               startActivity(intent)
               finish()
           }
            else
           {
               var intent = Intent(applicationContext, WelcomeActivity::class.java)
               startActivity(intent)
               finish()
           }
        },3000)
    }
}