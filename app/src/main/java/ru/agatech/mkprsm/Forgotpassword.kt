package ru.agatech.mkprsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_forgotpassword.*
//import xdroid.toaster.Toaster.toast

class Forgotpassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        sendmail.setOnClickListener {
            textView6.visibility = View.GONE
            editText.visibility = View.GONE
        }
    }
}
