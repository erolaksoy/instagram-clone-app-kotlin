package com.erolaksoy.instagramclone.Profile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.BottomnavigationViewHelper
import com.erolaksoy.instagramclone.utils.UniversalImageLoader
import kotlinx.android.synthetic.main.activity_profile.*


class Profile : AppCompatActivity() {


    private val ACTIVITY_NO = 4
    private val TAG= "Profile"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupToolbar()
        setupNavigationView()
        setupProfilePhoto()
    }

    private fun setupProfilePhoto() {
        val imgUrl="sosyalmedya.co/wp-content/uploads/2011/10/Steve-Jobs6-940x470.png"
        UniversalImageLoader.setImage(imgUrl,circleProfileImage,null,"https://")
    }

    private fun setupToolbar() {
        imgProfileSettings.setOnClickListener(){
            var intent = Intent(this,ProfileSettingsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }


        tvProfilDuzenleButton.setOnClickListener {
            profileRoot.visibility= View.GONE
            var transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileContainer,ProfileEditFragment())
            transaction.addToBackStack("Profil Edit Eklendi")
            transaction.commit()
        }



    }

    fun setupNavigationView(){
        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu=bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }

    override fun onBackPressed() {
        profileRoot.visibility=View.VISIBLE
        super.onBackPressed()
    }
}
