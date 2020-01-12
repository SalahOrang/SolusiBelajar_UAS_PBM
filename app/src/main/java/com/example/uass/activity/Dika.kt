package com.example.uass.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.uass.MainActivity
import com.example.uass.R
import kotlinx.android.synthetic.main.data_dicka.*

class Dika :AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_dicka)
        img_line_dika.setOnClickListener {
            val  i  = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/dhika_saktiandhika/?hl=id"))
            startActivity(i)
        }
        img_fb_dika.setOnClickListener {
            val  i  = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"))
            startActivity(i)
        }
        img_ig_dika.setOnClickListener {
            val  i  = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"))
            startActivity(i)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.optionmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === R.id.about) {
            startActivity(Intent(this, Abaut::class.java))
            finish()
        } else if (item.getItemId() === R.id.setting) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else if (item.getItemId() === R.id.help) {
            startActivity(Intent(this, ActivityDaftar::class.java))
            finish()
        }
        return true
    }

}