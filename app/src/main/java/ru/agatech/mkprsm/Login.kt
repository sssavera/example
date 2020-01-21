package ru.agatech.mkprsm

import Json4Kotlin_Base
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.*
import java.io.IOException

class Login : AppCompatActivity() {

    fun requestAuth(url: String) {

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
            .newBuilder()
            .build()

        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {

                val json = response.body()?.string()
                val topic = Gson().fromJson(json, Json4Kotlin_Base::class.java)

                if (topic.success.session_token != null)
                    startActivity(
                        Intent(this@Login, NavigationMenu::class.java)
                            .putExtra("session_token", topic.success.session_token)
                    )
            }

            override fun onFailure(call: Call, e: IOException) {

            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bin.setOnClickListener {
            requestAuth("https://mkp-ruy.ru/api/1.0/user/auth?" +
                    "login=${login.text}&password=${password.text}")
        }

        forgotpass.setOnClickListener {
            val i = Intent(this, Forgotpassword::class.java)
            startActivity(i)
        }
    }
}