package ru.agatech.mkprsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.activity_map_sale.*
import kotlinx.android.synthetic.main.activity_map_sale.back
import kotlinx.android.synthetic.main.activity_map_sale.next

class MapSale : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_sale)

        val ext = intent.getIntExtra("singup", 1)

        yamap.setOnClickListener {
            Toast
                .makeText(this, "Функция не доступна", Toast.LENGTH_LONG)
                .show()
        }

        if (ext == 1) {
            back.setOnClickListener {
                finish()
            }

            next.setOnClickListener {
                val i = Intent(this, Address::class.java).putExtra("singup", 1)
                    .putExtra("login",intent.extras!!.getString("login"))
                    .putExtra("password", intent.extras!!.getString("password"))
                    .putExtra("namesale", intent.extras!!.getString("namesale"))
                    .putExtra("engsale", intent.extras!!.getString("engsale"))
                    .putExtra("sizesale", intent.extras!!.getString("sizesale"))
                    .putExtra("providersale", intent.extras!!.getString("providersale"))
                    .putExtra("rusdescription", intent.extras!!.getString("rusdescription"))
                    .putExtra("engdescription", intent.extras!!.getString("engdescription"))
                    .putExtra("inn", intent.extras!!.getString("inn"))
                    .putExtra("email", intent.extras!!.getString("email"))
                    .putExtra("phonenumber", intent.extras!!.getString("phonenumber"))
                    .putExtra("sitecompany", intent.extras!!.getString("sitecompany"))
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
        } else {
            back.setOnClickListener {
                finish()
            }
        }
    }
}
