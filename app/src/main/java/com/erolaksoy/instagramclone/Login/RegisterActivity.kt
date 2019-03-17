package com.erolaksoy.instagramclone.Login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.erolaksoy.instagramclone.R
import com.erolaksoy.instagramclone.utils.EventBusDataEvents
import kotlinx.android.synthetic.main.activity_register.*
import org.greenrobot.eventbus.EventBus

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }

    private fun init() {
        tvEposta.setOnClickListener {
            viewTelefon.visibility= View.INVISIBLE
            viewEposta.visibility=View.VISIBLE
            etGirisYontemi.setText("")
            etGirisYontemi.inputType=InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            etGirisYontemi.setHint("E posta")
        }

        tvTelefon.setOnClickListener {
            viewTelefon.visibility= View.VISIBLE
            viewEposta.visibility=View.INVISIBLE
            etGirisYontemi.setText("")
            etGirisYontemi.inputType=InputType.TYPE_CLASS_NUMBER
            etGirisYontemi.setHint("Telefon")
        }

        etGirisYontemi.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               if(start+before+count>=10){
                   btnIleri.isEnabled=true
                   btnIleri.setTextColor(ContextCompat.getColor(this@RegisterActivity,R.color.beyaz))
                   btnIleri.setBackgroundColor(ContextCompat.getColor(this@RegisterActivity,R.color.mavi))

               }else{
                   btnIleri.isEnabled=false
                   btnIleri.setTextColor(ContextCompat.getColor(this@RegisterActivity,R.color.beyaz))
                   btnIleri.setBackgroundColor(ContextCompat.getColor(this@RegisterActivity,R.color.siyah))
               }

                btnIleri.setOnClickListener{
                    if(etGirisYontemi.hint.toString().equals("Telefon")){
                        loginRoot.visibility=View.GONE
                        loginContainer.visibility=View.VISIBLE
                        var transaction=supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.loginContainer,TelefonKoduGirFragment())
                        transaction.addToBackStack("Telefon kodu gir fragment eklendi")
                        transaction.commit()
                        EventBus.getDefault().postSticky(EventBusDataEvents.TelNoGonder(etGirisYontemi.text.toString()))



                    }else{
                        loginRoot.visibility=View.GONE
                        loginContainer.visibility=View.VISIBLE
                        var transaction=supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.loginContainer,EmailGirisYontemiFragment())
                        transaction.addToBackStack("Email giris  eklendi")
                        transaction.commit()
                        EventBus.getDefault().postSticky(EventBusDataEvents.EmailGonder(etGirisYontemi.text.toString()))
                    }

                }

            }
        })

    }

    override fun onBackPressed() {
        loginRoot.visibility=View.VISIBLE
        super.onBackPressed()
    }

}
