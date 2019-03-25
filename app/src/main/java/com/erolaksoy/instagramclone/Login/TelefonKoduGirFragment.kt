@file:Suppress("UNREACHABLE_CODE", "DEPRECATION")

package com.erolaksoy.instagramclone.Login


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.EventBusDataEvents
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_telefon_kodu_gir.*
import kotlinx.android.synthetic.main.fragment_telefon_kodu_gir.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.util.concurrent.TimeUnit


class TelefonKoduGirFragment : Fragment() {


    var gelenTelNo = ""
    lateinit var mCallbacks:PhoneAuthProvider.OnVerificationStateChangedCallbacks
    var verificationID=""
    var gelenKod =""
    lateinit var progressBar : ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View?{
        //return inflater.inflate(R.layout.fragment_telefon_kodu_gir, container, false)

        var view=inflater!!.inflate(R.layout.fragment_telefon_kodu_gir,container,false)

        view.tvKullaniciTelNo.text = gelenTelNo
        progressBar=view.pbTelNoOnayla
        setupCallBack()

        view.btnTelKodIleri.setOnClickListener {
            if(gelenKod.equals(view.etOnayKodu.text.toString())){
                EventBus.getDefault().postSticky(EventBusDataEvents.KayitBilgileriniGonder(gelenTelNo,null,verificationID,gelenKod,false))
                var transaction=activity!!.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.loginContainer,KayitFragment())
                transaction.addToBackStack("kayitFragment Eklendi")
                transaction.commit()



            }else{
                var transaction=activity!!.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.loginContainer,KayitFragment())
                transaction.addToBackStack("kayitFragment Eklendi")
                transaction.commit()
            }
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            gelenTelNo,      // Phone number to verify
            60,               // Timeout duration
            TimeUnit.SECONDS, // Unit of timeout
            this!!.activity!!,             // Activity (for callback binding)
            mCallbacks) // OnVerificationStateChangedCallbacks



        return view
}

    private fun setupCallBack() {
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                if (!credential.smsCode.isNullOrEmpty()) {
                    progressBar.visibility = View.INVISIBLE
                    gelenKod = credential.smsCode!!
                }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.e("HATA","Hata çıktı"+e.message)
            }

            override fun onCodeSent(
                verificationId: String?,
                token: PhoneAuthProvider.ForceResendingToken?

            ) {
                verificationID=verificationId!!
                progressBar.visibility=View.VISIBLE
            }
        }
    }


    @Subscribe (sticky = true)
    internal fun onTelefoNoEvent(kayitBilgileri : EventBusDataEvents.KayitBilgileriniGonder){
        gelenTelNo=kayitBilgileri.telNo!!
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
