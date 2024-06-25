package com.example.tugasppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class CardDesc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_desc)

        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_carddesc)
        navView.setItemIconTintList(null)

        val backIconHeadline = findViewById<ImageView>(R.id.back)
        backIconHeadline.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}