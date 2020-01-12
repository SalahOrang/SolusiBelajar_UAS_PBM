package com.example.uass.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uass.MainActivity
import com.example.uass.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detailpelajaran.*


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class ActivityDetailPelajaran : AppCompatActivity() {

    private lateinit var tvData : TextView
    private lateinit var image : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailpelajaran)

        tampil()
        funtombol()
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

    private fun funtombol() {
        btn_scroll_View.setOnClickListener {
            startActivity(Intent(this, ActivityBayar::class.java))
            finish()
        }
    }

    private fun tampil() {
        tvData = findViewById(R.id.tv_detail_Pelajaran)
        image = findViewById(R.id.image_detail_Pelajaran)
        tv_judulDetailPelajaran.setText(intent.getStringExtra("nama"))
        tvData.setText(intent.getStringExtra("detail"))

        Picasso.get()
            .load(intent.getStringExtra("gambar"))
            .resize(500, 300)
            .centerCrop()
            .into(image)
    }
}