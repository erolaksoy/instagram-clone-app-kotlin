package com.erolaksoy.instagramclone.Home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erolaksoy.instagramclone.R

class MainFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        var view=inflater?.inflate(R.layout.fragment_home,container,false)
       return view
    }

}