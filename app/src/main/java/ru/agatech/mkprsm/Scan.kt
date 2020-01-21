package ru.agatech.mkprsm

import Json4Kotlin
import Json4Kotlin_Base
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_scan.*
import okhttp3.*
import java.io.IOException

class Scan : AppCompatActivity() {

    var card: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        val s = IntentIntegrator(this)
        s.initiateScan()

        val token = intent.extras!!.getString("session_token")

        cardcheck.setOnClickListener {
            check("https://mkp-ruy.ru/api/1.0/user/check?session_token=$token&card=${cardnumber.text}")
        }

        scan2.setOnClickListener {
            IntentIntegrator(this).initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(this, "Отмена", Toast.LENGTH_LONG)
                        .show()
                } else {
                    cardnumber.setText(result.contents)
                    card += result.contents
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    fun check(url: String) {

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient().newBuilder().build()

        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {

                val jo = intent.extras!!.getString("session_token")
                val o = response.body()!!.string()
                val info = Gson().fromJson(o, Json4Kotlin::class.java)

                runOnUiThread {
                    AlertDialog.Builder(this@Scan)
                        .setTitle(info.success.text)
                        .setMessage("${info.success.userinfo.firstname}\n" +
                                "${info.success.userinfo.firstname_eng}\n" +
                                "${info.success.userinfo.lastname}\n" +
                                "${info.success.userinfo.lastname_eng}\n" +
                                "${info.success.userinfo.birthday}\n" +
                                "${info.success.userinfo.middlename}\n" +
                                "${info.success.userinfo.email}\n" +
                                "${info.success.userinfo.phone}\n" +
                                "${info.success.userinfo.card}")
                        .setPositiveButton("OK",
                            DialogInterface.OnClickListener { dialog, which ->  dialog.dismiss()})
                        .show()
                }
                Log.e("TAH", jo)
                Log.e("RESPONSE", info.success.text)
            }

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(this@Scan, e.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
