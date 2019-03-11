package com.erolaksoy.instagramclone.Profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.BottomnavigationViewHelper

import kotlinx.android.synthetic.main.activity_profile_settings.*

class ProfileSettingsActivity : AppCompatActivity() {

    private val ACTIVITY_NO = 4
    private val TAG= "Profile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)
        setupNavigationView()
        setupToolbar()
    }

    private fun setupToolbar() {
        imgBack.setOnClickListener{
            onBackPressed()
        }
    }

    fun setupNavigationView(){
        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu=bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }

}
