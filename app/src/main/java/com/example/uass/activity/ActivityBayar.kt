package com.example.uass.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uass.MainActivity
import com.example.uass.R
import kotlinx.android.synthetic.main.activity_bayar.*


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class ActivityBayar : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bayar)

        btn_proses.setOnClickListener {
            startActivity(Intent(this,ActivitySoal::class.java))
        }

       btn_belitoken.setOnClickListener {
           startActivity(Intent(this,BeliToken::class.java))
           finish()
        }

        btn_lanjut.setOnClickListener {
            if (uangbayar!==null){
                startActivity(Intent(this,ActivitySoal::class.java))
                finish()
            }
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
