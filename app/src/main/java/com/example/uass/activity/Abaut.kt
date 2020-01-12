package com.example.uass.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.uass.MainActivity
import com.example.uass.R
import kotlinx.android.synthetic.main.activity_abaut.*

class Abaut : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abaut)
        id_Zaki.setOnClickListener{
            startActivity(Intent(this, Zaki::class.java))
            finish()
        }
        id_Dika.setOnClickListener {
            startActivity(Intent(this, Dika::class.java))
            finish()
        }
        id_Dorik_Setyawan.setOnClickListener{
            startActivity(Intent(this, Dorik::class.java))
            finish()
        }
        id_TJ.setOnClickListener {
            startActivity(Intent(this, TJ::class.java))
            finish()
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
