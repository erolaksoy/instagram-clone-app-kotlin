package com.erolaksoy.instagramclone.utils

import android.content.Context
import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.erolaksoy.instagramclone.Home.MainActivity
import com.erolaksoy.instagramclone.News.News
import com.erolaksoy.instagramclone.Profile.Profile
import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.Search.Search
import com.erolaksoy.instagramclone.Share.Share
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

class BottomnavigationViewHelper {

    companion object {

        fun setupBottomNavigationView(bottomnavigationViewEx: BottomNavigationViewEx){
            bottomnavigationViewEx.enableAnimation(false)
            bottomnavigationViewEx.enableItemShiftingMode(false)
            bottomnavigationViewEx.enableShiftingMode(false)
            bottomnavigationViewEx.setTextVisibility(false)
        }

        fun setupNavigation(context: Context, bottomnavigationViewEx: BottomNavigationViewEx){

            bottomnavigationViewEx.onNavigationItemSelectedListener=object :BottomNavigationView.OnNavigationItemSelectedListener{
                override fun onNavigationItemSelected(item: MenuItem): Boolean {

                    when(item.itemId){

                        R.id.ic_home -> {

                                val intent = Intent(context, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                                context.startActivity(intent)
                                return true


                        }

                        R.id.ic_search -> {

                                val intent = Intent(context, Search::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                                context.startActivity(intent)
                                return true

                        }

                        R.id.ic_share -> {

                                val intent = Intent(context, Share::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                                context.startActivity(intent)
                                return true


                        }

                        R.id.ic_news -> {

                                val intent = Intent(context, News::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                                context.startActivity(intent)
                                return true


                        }

                        R.id.ic_profile -> {

                                val intent = Intent(context, Profile::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                                context.startActivity(intent)
                                return true

                        }



                    }

                    return false
                }


            }

        }


    }

}