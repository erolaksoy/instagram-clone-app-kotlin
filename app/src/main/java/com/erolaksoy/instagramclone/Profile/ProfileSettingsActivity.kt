package com.erolaksoy.instagramclone.Profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        fragmentNavigations()
    }

    private fun fragmentNavigations() {
        tvProfilDuzenleHesapAyarlari.setOnClickListener{
            profile_settings_root.visibility= View.GONE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileSettingsContainer,ProfileEditFragment())
            transaction.addToBackStack("Profili Düzenle Fragment Eklendi")
            transaction.commit()

        }

        tvCikisYap.setOnClickListener {
            profile_settings_root.visibility=View.GONE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileSettingsContainer,SignOutFragment())
            transaction.addToBackStack("SignOut Fragment Eklendi")
            transaction.commit()
        }

    }

    private fun setupToolbar() {
        imgBack.setOnClickListener{
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        profile_settings_root.visibility=View.VISIBLE
        super.onBackPressed()
    }

    fun setupNavigationView(){
        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu=bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }

}
