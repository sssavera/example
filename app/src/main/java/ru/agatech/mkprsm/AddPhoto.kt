package ru.agatech.mkprsm

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_photo.*
import kotlinx.android.synthetic.main.activity_add_photo.back
import kotlinx.android.synthetic.main.activity_add_photo.next
import kotlinx.android.synthetic.main.activity_address.*

class AddPhoto : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_photo)

        val ext = intent.getIntExtra("singup", 1)

        addphoto1.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    val permission = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permission, PERMISSION_CODE)
                } else {
                    count++
                    pickImage()
                }
            } else {
                count++
                pickImage()
            }
        }

        addphoto2.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    val permission = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permission, PERMISSION_CODE)
                } else {
                    count += 1
                    pickImage()
                }
            } else {
                count += 2
                pickImage()
            }
        }

        back.setOnClickListener {
            finish()
        }

        next.setOnClickListener {
            val i = Intent(this, ThankForReg::class.java)
                .putExtra("login", intent.extras!!.getString("login"))
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
                .putExtra("street", intent.extras!!.getString("street"))
                .putExtra("city", intent.extras!!.getString("city"))
                .putExtra("region", intent.extras!!.getString("region"))
                .putExtra("country", intent.extras!!.getString("country"))
                .putExtra("index", intent.extras!!.getString("index"))
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

    fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        private val IMAGE_PICK_CODE = 1000
        private val PERMISSION_CODE = 1001
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) pickImage()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK &&
            requestCode == IMAGE_PICK_CODE
        ) {
            if (count == 1) photo1.setImageURI(data?.data)
            if (count == 2) photo2.setImageURI(data?.data)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}