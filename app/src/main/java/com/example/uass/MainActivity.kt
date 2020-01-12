package com.example.uass

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.RecyclerView
import bersatu.kita.part11.Model.Pelajaran
import com.example.uass.activity.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var btntk: Button
    private lateinit var btnsd: Button
    private lateinit var btnsmp: Button
    private lateinit var btnsma: Button
    private lateinit var rvHeroes: RecyclerView
    private var title = "Mode List"
    private val list = ArrayList<Pelajaran>()

    private lateinit var appBarConfiguration: AppBarConfiguration

    private var TAG = "data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        fungsibtn()

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
    private fun fungsibtn() {
        btntk = findViewById(R.id.btnTk)
        btnsd = findViewById(R.id.btnSD)
        btnsmp = findViewById(R.id.btnSMP)
        btnsma = findViewById(R.id.btnSMA)

        btntk.setOnClickListener {
            startActivity(Intent(this, ActivityTk::class.java))
        }

        btnsd.setOnClickListener {
            startActivity(Intent(this, ActivitySd::class.java))
        }
        btnsmp.setOnClickListener {
            startActivity(Intent(this, ActivitySmp::class.java))
        }
        btnsma.setOnClickListener {
            startActivity(Intent(this, ActivitySma::class.java))
        }
    }

}
