package ru.agatech.mkprsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_personality.*
import kotlinx.android.synthetic.main.activity_personality.back
import kotlinx.android.synthetic.main.activity_personality.next

class Personality : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personality)

        val ext = intent.getIntExtra("singup",1)

        if (ext == 1){

            back.setOnClickListener {
                finish()
            }

            next.setOnClickListener {

                if (inn.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание не полное", Toast.LENGTH_SHORT)
                        .show()
                }

                else if (email.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание не полное", Toast.LENGTH_SHORT)
                        .show()
                }

                else if (phonenumber.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание не полное", Toast.LENGTH_SHORT)
                        .show()
                }

                else if (sitecompany.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание не полное", Toast.LENGTH_SHORT)
                        .show()
                }

                else {
                    val i = Intent(this, MapSale::class.java)
                        .putExtra("singup", 1)
                        .putExtra("login", intent.extras!!.getString("login"))
                        .putExtra("password", intent.extras!!.getString("password"))
                        .putExtra("namesale", intent.extras!!.getString("namesale"))
                        .putExtra("engsale", intent.extras!!.getString("engsale"))
                        .putExtra("sizesale", intent.extras!!.getString("sizesale"))
                        .putExtra("providersale", intent.extras!!.getString("providersale"))
                        .putExtra("rusdescription", intent.extras!!.getString("rusdescription"))
                        .putExtra("engdescription", intent.extras!!.getString("engdescription"))
                        .putExtra("inn", inn.text!!.toString())
                        .putExtra("email", email.text!!.toString())
                        .putExtra("phonenumber", phonenumber.text!!.toString())
                        .putExtra("sitecompany", sitecompany.text!!.toString())
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

            inn.setText("${intent.extras!!.getString("inn")}")
            email.setText("${intent.extras!!.getString("email")}")
            phonenumber.setText("${intent.extras!!.getString("phonenumber")}")
            sitecompany.setText("${intent.extras!!.getString("sitecompany")}")
        }
    }
}
