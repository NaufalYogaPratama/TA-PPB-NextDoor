package com.example.tugasppb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: HeadlineAdapter
    lateinit var imageList: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myCardView1 = findViewById<CardView>(R.id.cardview_1)
        myCardView1.setOnClickListener {
            val intent = Intent(this, CardDesc::class.java)
            startActivity(intent)
        }

        val myCardView2 = findViewById<CardView>(R.id.cardview_2)
        myCardView2.setOnClickListener {
            val intent = Intent(this, CardDesc::class.java)
            startActivity(intent)
        }

        val myCardView3 = findViewById<CardView>(R.id.cardview_3)
        myCardView3.setOnClickListener {
            val intent = Intent(this, CardDesc::class.java)
            startActivity(intent)
        }


        val logoutButton = findViewById<ImageView>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            // Perform logout actions here

            // For example, if you're using shared preferences for session management:
            val sharedPref = getSharedPreferences("my_pref", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()

            // Navigate back to the login activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish the current activity to prevent going back
        }

        val navView: BottomNavigationView = findViewById(R.id.bottom_nav)
        navView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
//                R.id.itemhome -> {
////                    menuItem.setIcon(R.drawable.icon_homecheck1)
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
                R.id.itemprogres -> {
//                    menuItem.setIcon(R.drawable.icon_book2)
                    val intent = Intent(this, ProgressActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
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

        // initializing variables
        // of below line with their id.
        val viewPager = findViewById<ViewPager>(R.id.headline)

        // on below line we are initializing
        // our image list and adding data to it.
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.missing2
        imageList = imageList + R.drawable.missing1
        imageList = imageList + R.drawable.missing3
        imageList = imageList + R.drawable.missing4

        // on below line we are initializing our view
        // pager adapter and adding image list to it.
        viewPagerAdapter = HeadlineAdapter(this@MainActivity, imageList)

        // on below line we are setting
        // adapter to our view pager.
        viewPager.adapter = viewPagerAdapter
    }
}