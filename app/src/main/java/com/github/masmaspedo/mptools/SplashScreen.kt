package com.github.masmaspedo.mptools

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class SplashScreen : AppCompatActivity() {

    var durations : Long  = 1500;
    lateinit var ctx : Context;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ctx = this;
        setContentView(R.layout.activity_splashscreen)
        Handler().postDelayed({
            val main : Intent = Intent(this,MainActivity::class.java);
            startActivity(main);
            finish();
        },durations);
    }
}