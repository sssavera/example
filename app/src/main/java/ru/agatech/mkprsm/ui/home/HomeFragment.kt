package ru.agatech.mkprsm.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_home.view.*
import ru.agatech.mkprsm.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val token = activity!!.intent.extras!!.getString("session_token")
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.textView4)

        root.contact.setOnClickListener { view ->
            val contact = Intent(activity, Personality::class.java)
                .putExtra("singup", 2)
//                .putExtra("user", activity!!.intent.extras!!.getString("user"))
            startActivity(contact)
        }

        root.infinc.setOnClickListener { view ->
            val infinc = Intent(activity, AboutCompany::class.java)
                .putExtra("singup",2)
//                .putExtra("user", activity!!.intent.extras!!.getString("user"))
            startActivity(infinc)
        }

        root.infosale.setOnClickListener { view ->
            val infosale = Intent(activity, Categories::class.java)
                .putExtra("singup",2)
//                .putExtra("user", activity!!.intent.extras!!.getString("user"))
            startActivity(infosale)
        }

        root.photo.setOnClickListener { view ->
            val photo = Intent(activity, AddPhoto::class.java)
                .putExtra("singup",2)
//                .putExtra("user", activity!!.intent.extras!!.getString("user"))
            startActivity(photo)
        }
/*
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
*/
        return root
    }
}