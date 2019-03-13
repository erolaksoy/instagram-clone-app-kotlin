package com.erolaksoy.instagramclone.Profile


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.UniversalImageLoader
import com.nostra13.universalimageloader.core.ImageLoader
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_profile_edit.*
import kotlinx.android.synthetic.main.fragment_profile_edit.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileEditFragment : Fragment() {

    lateinit var circleProfileImage:CircleImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile_edit, container, false)
        circleProfileImage=view.circleProfileImage
        initImageLodaer()
        setupProfilePicture()



        view.imgClose.setOnClickListener {
            this.activity!!.onBackPressed()
        }

    return view
    }

    private fun initImageLodaer(){
        var universalImageLoader=UniversalImageLoader(this.activity!!)
        ImageLoader.getInstance().init(universalImageLoader.config)
    }


    private fun setupProfilePicture() {
            var imgURL = "img-s2.onedio.com/id-57b6a4299825c5487fcaa8d3/rev-0/raw/s-9bb15a833a669492b42b314eed960d7d197cd084.jpg"
            UniversalImageLoader.setImage(imgURL,circleProfileImage,null,"https://")
    }


}
