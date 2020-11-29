package com.github.masmaspedo.mptools

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.masmaspedo.mptools.fragment.GameFragment
import com.github.masmaspedo.mptools.fragment.HomeFragment
import com.github.masmaspedo.mptools.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.shape.*

class MainActivity : AppCompatActivity() {
    lateinit var btm : BottomNavigationView
    lateinit var ctx : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ctx = this
        setContentView(R.layout.activity_main)
        btm = findViewById(R.id.bottom_nav)
        btm.rounded(CornerFamily.ROUNDED,55.toFloat())
        fragmentLoader(HomeFragment())
        btm.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home ->{
                    fragmentLoader(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.bottom_gaming ->{
                    fragmentLoader(GameFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.bottom_setting->{
                    fragmentLoader(SettingFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

    fun BottomNavigationView.rounded(corner : Int, radius : Float) {
        val bottomBackground : MaterialShapeDrawable = background as MaterialShapeDrawable
        bottomBackground.shapeAppearanceModel = bottomBackground.shapeAppearanceModel.toBuilder()
            .setAllCorners(corner,radius)
            .build()
    }

    fun fragmentLoader(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_main,fragment).commit()
    }
}