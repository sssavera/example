package ru.agatech.mkprsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_about_sale.*
import ru.agatech.mkprsm.db.AppPrefs


class AboutSale : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_sale)

        AppPrefs.init(this)

        val ext = intent.getIntExtra("singup",1)
        if (ext == 1) {
            back.setOnClickListener {
                finish()
            }

            next.setOnClickListener {

                if (namesale.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание скидки не полное", Toast.LENGTH_SHORT)
                        .show()
                }

                else if (engsale.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание скидки не полное", Toast.LENGTH_SHORT)
                        .show()
                }

                else if (providersale.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание скидки не полное", Toast.LENGTH_SHORT)
                        .show()
                }

                else if (sizesale.text.toString() == "") {
                    Toast
                        .makeText(this, "Описание скидки не полное", Toast.LENGTH_SHORT)
                        .show()
                }

                else {

                    val i = Intent(this, AboutCompany::class.java)
                        .putExtra("singup", 1)
                        .putExtra("login", intent.extras!!.getString("login"))
                        .putExtra("password", intent.extras!!.getString("password"))
                        .putExtra("namesale", namesale.text.toString())
                        .putExtra("engsale", engsale.text.toString())
                        .putExtra("sizesale", sizesale.text.toString())
                        .putExtra("providersale", providersale.text.toString())
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

            next.setOnClickListener {finish()}
        }
    }
}
