package ru.agatech.mkprsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.agatech.mkprsm.ui.WEb
import ru.agatech.mkprsm.ui.WebLog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        singup.setOnClickListener {
            val i = Intent(this, LogPassReg::class.java)
                .putExtra("singup", 1)
            startActivity(i)
        }

        login.setOnClickListener {
            val l = Intent(this, Login::class.java)
                .putExtra("admin", false)
            startActivity(l)
        }

        webreg.setOnClickListener {
            startActivity(Intent(this, WEb::class.java))
        }

        weblogin.setOnClickListener { startActivity(
            Intent(this, WebLog::class.java))
        }

        logo.isClickable = true
        logo.setOnClickListener {
            startActivity(
                Intent(this, NavigationMenu::class.java)
                    .putExtra("admin", true))
        }
    }
}
