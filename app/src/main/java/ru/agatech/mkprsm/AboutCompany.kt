package ru.agatech.mkprsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_about_company.*
//import ninja.sakib.pultusorm.core.PultusORM
import ru.agatech.mkprsm.db.PartnerDB

class AboutCompany : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_company)

        val ext = intent.getIntExtra("singup",1)

        if (ext == 1) {

            back.setOnClickListener {
                finish()
            }

            next.setOnClickListener {
                if (rusdescription.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание не полное", Toast.LENGTH_SHORT)
                        .show()
            }

                else if (engdescription.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание не полное", Toast.LENGTH_SHORT)
                        .show()
                }

                else {
                    val i = Intent(this, Personality::class.java)
                        .putExtra("singup", 1)
                        .putExtra("login", intent.extras!!.getString("login"))
                        .putExtra("password", intent.extras!!.getString("password"))
                        .putExtra("namesale", intent.extras!!.getString("namesale"))
                        .putExtra("engsale", intent.extras!!.getString("engsale"))
                        .putExtra("sizesale", intent.extras!!.getString("sizesale"))
                        .putExtra("providersale", intent.extras!!.getString("providersale"))
                        .putExtra("rusdescription", rusdescription.text.toString())
                        .putExtra("engdescription", engdescription.text.toString())
                        .putExtra("category", intent.extras!!.getBoolean("category"))
                        .putExtra("category2", intent.extras!!.getBoolean("category2"))
                        .putExtra("category3", intent.extras!!.getBoolean("category3"))
                        .putExtra("category4", intent.extras!!.getBoolean("category4"))
                        .putExtra("category5", intent.extras!!.getBoolean("category5"))
                        .putExtra("category6", intent.extras!!.getBoolean("category6"))
                        .putExtra("category7", intent.extras!!.getBoolean("category7"))
                        .putExtra("category8", intent.extras!!.getBoolean("category8"))
                        .putExtra("tag", intent.extras!!.getBoolean("tag"))
                        .putExtra("tag2", intent.extras!!.getBoolean("tag2"))
                        .putExtra("tag3", intent.extras!!.getBoolean("tag3"))
                        .putExtra("tag4", intent.extras!!.getBoolean("tag4"))
                    startActivity(i)
                }
            }
        } else {

            back.setOnClickListener {
                finish()
            }

            next.setOnClickListener {
                startActivity(Intent(this, Address::class.java)
                    .putExtra("singup", 2)
                    .putExtra("login", intent.extras!!.getString("login"))
                    .putExtra("password", intent.extras!!.getString("password"))
                    .putExtra("city", intent.extras!!.getString("city"))
                    .putExtra("street", intent.extras!!.getString("street"))
                    .putExtra("country", intent.extras!!.getString("country"))
                    .putExtra("region", intent.extras!!.getString("region"))
                    .putExtra("index", intent.extras!!.getString("index"))
                )
            }
        }
    }
}
