package com.erolaksoy.instagramclone.Search

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.BottomnavigationViewHelper
import kotlinx.android.synthetic.main.activity_main.*

class Search : AppCompatActivity() {


    private val ACTIVITY_NO = 1
    private val TAG= "Search"
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
