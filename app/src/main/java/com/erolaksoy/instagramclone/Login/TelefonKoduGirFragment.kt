package com.erolaksoy.instagramclone.Login


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.EventBusDataEvents
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class TelefonKoduGirFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View?{
        return inflater.inflate(R.layout.fragment_telefon_kodu_gir, container, false)
}


    @Subscribe (sticky = true)
    internal fun onTelefoNoEvent(telefonNumarasi : EventBusDataEvents.TelNoGonder){
        var gelenTelNo=telefonNumarasi.telNo
        Log.e("erol","Gelen tel no " + gelenTelNo)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }

}
