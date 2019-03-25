package com.erolaksoy.instagramclone.Login


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.EventBusDataEvents
import kotlinx.android.synthetic.main.fragment_kayit.*
import kotlinx.android.synthetic.main.fragment_kayit.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class KayitFragment : Fragment() {

    var telNo=""
    var verificationID=""
    var gelenKod=""
    var gelenEmail=""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view =  inflater.inflate(R.layout.fragment_kayit, container, false)


        view.etAdSoyad.addTextChangedListener(watcher)
        view.etKullaniciAdi.addTextChangedListener(watcher)
        view.etSifre.addTextChangedListener(watcher)


        return view
    }

    var watcher : TextWatcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(s!!.length>5){

                if(etAdSoyad.text.toString().length>5 && etKullaniciAdi.text.toString().length>5 && etSifre.text.toString().length>5){
                    btnGiris.isEnabled=true
                    btnGiris.setTextColor(ContextCompat.getColor(activity!!,R.color.mavi))
                }else{
                    btnGiris.isEnabled=false
                    btnGiris.setTextColor(ContextCompat.getColor(activity!!,R.color.siyah))
                }

            }else{
                btnGiris.isEnabled=false
                btnGiris.setTextColor(ContextCompat.getColor(activity!!,R.color.siyah))
            }
        }

    }


    @Subscribe(sticky = true)
    internal fun onKayitEvent(kayitBilgileri : EventBusDataEvents.KayitBilgileriniGonder) {

        if (kayitBilgileri.eMailKontrol == true) {

            var gelenEmail = kayitBilgileri.eMail!!
            Toast.makeText(activity,"Gelen Email : " + gelenEmail,Toast.LENGTH_SHORT).show()
            Log.e("erol", "Gelen email " + gelenEmail)
        }else{
                telNo==kayitBilgileri.telNo!!
                verificationID==kayitBilgileri.verificationID!!
                gelenKod==kayitBilgileri.code!!

            Toast.makeText(activity,"Gelen Kod : " +gelenKod+"Verification ID : "+verificationID,Toast.LENGTH_SHORT).show()
            }
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
