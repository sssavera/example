package ru.agatech.mkprsm

import Json4Kotlin_Reg
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_thank_for_reg.*
import okhttp3.*
import ru.agatech.mkprsm.db.PartnerDB
import java.io.IOException

class ThankForReg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_for_reg)

        var categories: String = ""
        var tags: String = ""

        if (intent.extras!!.getBoolean("category")) categories += "2"
        if (intent.extras!!.getBoolean("category2")) categories += ",3"
        if (intent.extras!!.getBoolean("category3")) categories += ",4"
        if (intent.extras!!.getBoolean("category4")) categories += ",5"
        if (intent.extras!!.getBoolean("category5")) categories += ",6"
        if (intent.extras!!.getBoolean("category6")) categories += ",7"
        if (intent.extras!!.getBoolean("category7")) categories += ",8"
        if (intent.extras!!.getBoolean("category8")) categories += ",9"
        if (intent.extras!!.getBoolean("tag")) tags += "1"
        if (intent.extras!!.getBoolean("tag2")) tags += ",2"
        if (intent.extras!!.getBoolean("tag3")) tags += ",3"
        if (intent.extras!!.getBoolean("tag4")) tags += ",4"

        request.setOnClickListener {
            requestRun ("https://mkp-ruy.ru/api/1.0/user/reg?" +
                    "name=${intent.extras!!.getString("providersale")}" +
                    "&category=2,4,3,5" +
                    "&city=${intent.extras!!.getString("city")}" +
                    "&region=${intent.extras!!.getString("region")}" +
                    "&geo=56.475757,84.974966" +
                    "&description=${intent.extras!!.getString("description")}" +
                    "&url=${intent.extras!!.getString("citecompany")}" +
                    "&title=${intent.extras!!.getString("namesale")}" +
                    "&title_eng=${intent.extras!!.getString("engsale")}" +
                    "&inn=${intent.extras!!.getString("inn")}" +
                    "&description_eng=${intent.extras!!.getString("engdescription")}" +
                    "&email=${intent.extras!!.getString("email")}" +
                    "&password=${intent.extras!!.getString("password")}" +
                    "&password_sec=${intent.extras!!.getString("password")}" +
                    "&phone=${intent.extras!!.getString("phone")}" +
                    "&street=${intent.extras!!.getString("street")}" +
                    "&post_index=${intent.extras!!.getString("index")}" +
                    "&tags=Ресторан}" +
                    "&photo=https://example.com/example.jpg" +
                    "&gallery=https://example.com/example.jpg" +
                    "&country_code=RU" +
                    "&discount=15" +
                    "&country=${intent.extras!!.getString("country")}")
        }
    }

    fun requestRun(url: String) {

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient().newBuilder().build()

        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {

                var json = response.body()!!.string()
                var data = Gson().fromJson(json, Json4Kotlin_Reg::class.java)
/*
                runOnUiThread {

                    Log.e("RIP", data.toString())

                    AlertDialog.Builder(this@ThankForReg)
                        .setTitle("Ошибка")
                        .setMessage(data.error.text)
                        .setPositiveButton("OK",
                            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
                        .show()
                }
                */
            }

            override fun onFailure(call: Call, e: IOException) {
                Toast
                    .makeText(this@ThankForReg, "Проблемы с соединением", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}