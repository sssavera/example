package ru.agatech.mkprsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_log_pass_reg.*
import ru.agatech.mkprsm.db.AppPrefs
//import xdroid.toaster.Toaster.toast
import java.io.*

class LogPassReg : AppCompatActivity() {
    //create DB. var db = PartnerDB(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_pass_reg)

        AppPrefs.init(this)

        next.setOnClickListener {

            if (createlogin.text.toString() == "")
                Toast
                    .makeText(this, "Придумайте логин", Toast.LENGTH_SHORT)
                    .show()

            else if (createpassword.text.toString() == "")
                Toast
                    .makeText(this, "Придумайте пароль", Toast.LENGTH_SHORT)
                    .show()

            else if (createpassword.text.toString() == repeatpassword.text.toString()) {

                val i = Intent(this, Categories::class.java)
                    .putExtra("singup", 1)
                    .putExtra("login", createlogin.text!!.toString())
                    .putExtra("password", createpassword.text!!.toString())
                startActivity(i)

            } else
                Toast
                    .makeText(this, "Пароль не совпадает", Toast.LENGTH_SHORT)
                    .show()
        }
        back.setOnClickListener {
            finish()
        }
    }

}