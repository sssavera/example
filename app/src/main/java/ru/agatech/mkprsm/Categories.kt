package ru.agatech.mkprsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_categories.*
//import xdroid.toaster.Toaster.toast

class Categories : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        back.setOnClickListener {
            finish()
            /*
            val i = Intent(this, LogPassReg::class.java)
            startActivity(i)
            */
        }
        var cat: Int = 0
        val ext = intent.getIntExtra("singup",1)
        if (ext == 1) {

            next.setOnClickListener {

                val i = Intent(this, Tags::class.java)
                    .putExtra("singup",1)
                    .putExtra("login", intent.extras?.getString("login"))
                    .putExtra("password", intent.extras?.getString("password"))
                    .putExtra("category", categorybox.isChecked)
                    .putExtra("category2", categorybox2.isChecked)
                    .putExtra("category3", categorybox3.isChecked)
                    .putExtra("category4", categorybox4.isChecked)
                    .putExtra("category5", categorybox5.isChecked)
                    .putExtra("category6", categorybox6.isChecked)
                    .putExtra("category7", categorybox7.isChecked)
                    .putExtra("category8", categorybox8.isChecked)

                if (categorybox.isChecked || categorybox2.isChecked || categorybox3.isChecked
                    || categorybox4.isChecked || categorybox5.isChecked || categorybox6.isChecked
                    || categorybox7.isChecked || categorybox8.isChecked) startActivity(i)

                else
                    Toast
                        .makeText(this,
                            "Выберите одну или несколько категорий", Toast.LENGTH_SHORT)
                        .show()
                }

        } else {

            if (intent.extras!!.getBoolean("category"))
                categorybox.isChecked = true
            if (intent.extras!!.getBoolean("category2"))
                categorybox2.isChecked = true
            if (intent.extras!!.getBoolean("category3"))
                categorybox3.isChecked = true
            if (intent.extras!!.getBoolean("category4"))
                categorybox4.isChecked = true
            if (intent.extras!!.getBoolean("category5"))
                categorybox5.isChecked = true
            if (intent.extras!!.getBoolean("category6"))
                categorybox6.isChecked = true
            if (intent.extras!!.getBoolean("category7"))
                categorybox7.isChecked = true
            if (intent.extras!!.getBoolean("category8"))
                categorybox8.isChecked = true

            next.setOnClickListener {
                startActivity(Intent(this, Tags::class.java)
                    .putExtra("singup", 2)
                    .putExtra("namesale", intent.extras!!.getString("namesale"))
                    .putExtra("engsale", intent.extras!!.getString("engsale"))
                    .putExtra("sizesale", intent.extras!!.getString("sizesale"))
                    .putExtra("providersale", intent.extras!!.getString("providersale"))
                )
                finish()
            }

            back.setOnClickListener {
                finish()
            }
        }
    }
}
