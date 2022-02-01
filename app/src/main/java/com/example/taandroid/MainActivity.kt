package com.example.taandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import com.example.taandroid.fragment.HomeFragment
import com.example.taandroid.fragment.KeranjangFragment
import com.example.taandroid.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment()
    val fragmentProfile: Fragment = ProfileFragment()
    val fragmentKeranjang: Fragment = KeranjangFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuitem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentProfile).hide(fragmentProfile).commit()
        fm.beginTransaction().add(R.id.container, fragmentKeranjang).hide(fragmentKeranjang)
            .commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuitem = menu.getItem(0)
        menuitem.isChecked = true

        bottomNavigationView.setOnItemSelectedListener { item ->

            when(item.itemId){
                R.id.page_1->{
                    callFragment(0, fragmentHome)
                }
                R.id.page_2->{
                    callFragment(1, fragmentKeranjang)
                }
                R.id.page_3->{
                    callFragment(2, fragmentProfile)
                }
            }

            false
        }
    }

    fun setUpBottomNav(){

    }

    fun callFragment(int: Int, fragment: Fragment){
        menuitem = menu.getItem(int)
        menuitem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }

}