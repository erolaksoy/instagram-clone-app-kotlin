package com.erolaksoy.instagramclone.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.BottomnavigationViewHelper
import com.erolaksoy.instagramclone.utils.HomePagerAdapter
import com.erolaksoy.instagramclone.utils.UniversalImageLoader
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val ACTIVITY_NO = 0
    private val TAG= "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationView()
        setupHomeViewPager()
        initImageLodaer()
    }



    fun setupNavigationView(){
        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu=bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }

    private fun setupHomeViewPager() {
        var homePagerAdapter=HomePagerAdapter(supportFragmentManager)
        homePagerAdapter.addFragment(CameraFragment())
        homePagerAdapter.addFragment(MainFragment())
        homePagerAdapter.addFragment(MessagesFragment())

        homeViewPager.adapter=homePagerAdapter

        homeViewPager.setCurrentItem(1)
    }

    private fun initImageLodaer(){
        var universalImageLoader= UniversalImageLoader(this)
        ImageLoader.getInstance().init(universalImageLoader.config)
    }

}
