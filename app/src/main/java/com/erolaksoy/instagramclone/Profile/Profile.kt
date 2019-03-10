package com.erolaksoy.instagramclone.Profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.BottomnavigationViewHelper
import kotlinx.android.synthetic.main.activity_main.*

class Profile : AppCompatActivity() {


    private val ACTIVITY_NO = 4
    private val TAG= "Profile"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationView()
    }

    fun setupNavigationView(){
        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu=bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }
}
