package com.example.tugasppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProgressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_progress)

        navView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.itemhome -> {
//                    menuItem.setIcon(R.drawable.icon_homecheck1)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
//                R.id.itemprogres -> {
////                    menuItem.setIcon(R.drawable.icon_book2)
//                    val intent = Intent(this, ProgressActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
                else -> false
            }
        }
//
//        navView.setOnItemReselectedListener { menuItem->
//            when(menuItem.itemId) {
//                R.id.itemhome -> {
//                    menuItem.setIcon(R.drawable.icon_home2)
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//                R.id.itemprogres -> {
//                    menuItem.setIcon(R.drawable.icon_book1)
//                    val intent = Intent(this, ProgressActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//            }
//        }
        navView.setItemIconTintList(null)

        val backIconProgress = findViewById<ImageView>(R.id.iconback)
        backIconProgress.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}