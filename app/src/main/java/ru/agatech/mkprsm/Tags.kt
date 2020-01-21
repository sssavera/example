package ru.agatech.mkprsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tags.*

class Tags : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tags)

        val num = intent.getIntExtra("singup", 1)
        if (num == 1) {
            back.setOnClickListener {
                finish()
            }

            next.setOnClickListener {
                val i = Intent(this, AboutSale::class.java)
                    .putExtra("singup", 1)
                    .putExtra("login", intent.extras!!.getString("login"))
                    .putExtra("password", intent.extras!!.getString("password"))
                    .putExtra("category", intent.extras!!.getBoolean("category"))
                    .putExtra("category2", intent.extras!!.getBoolean("category2"))
                    .putExtra("category3", intent.extras!!.getBoolean("category3"))
                    .putExtra("category4", intent.extras!!.getBoolean("category4"))
                    .putExtra("category5", intent.extras!!.getBoolean("category5"))
                    .putExtra("category6", intent.extras!!.getBoolean("category6"))
                    .putExtra("category7", intent.extras!!.getBoolean("category7"))
                    .putExtra("category8", intent.extras!!.getBoolean("category8"))
                    .putExtra("tag", tagbox.isChecked)
                    .putExtra("tag2", tagbox2.isChecked)
                    .putExtra("tag3", tagbox3.isChecked)
                    .putExtra("tag4", tagbox4.isChecked)

                if (tagbox.isChecked || tagbox2.isChecked || tagbox3.isChecked || tagbox4.isChecked)
                    startActivity(i)
                else
                    Toast
                        .makeText(this, "Выберите хотя бы что-то", Toast.LENGTH_SHORT)
                        .show()
            }

        } else {
            back.setOnClickListener {
                finish()
            }

            if (intent.extras!!.getBoolean("tag"))
                tagbox.isChecked = true
            if (intent.extras!!.getBoolean("tag2"))
                tagbox2.isChecked = true
            if (intent.extras!!.getBoolean("tag3"))
                tagbox3.isChecked = true
            if (intent.extras!!.getBoolean("tag4"))
                tagbox4.isChecked = true

            next.setOnClickListener {
                startActivity(Intent(this, AboutSale::class.java)
                    .putExtra("singup", 2))
                finish()
            }
        }
    }
}
