package com.example.tugasppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

class HeadlineDesc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headline_desc)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navheaddesc)
        navView.setItemIconTintList(null)

        val backIconHeadline = findViewById<ImageView>(R.id.iconback)
        backIconHeadline.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}