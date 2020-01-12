package com.example.uass.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bersatu.kita.part11.Model.Pelajaran
import com.example.uass.ListAdapter
import com.example.uass.MainActivity
import com.example.uass.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList


class ActivityMataPelajaran: AppCompatActivity() {
    private lateinit var rvData: RecyclerView
    private var title = "Mode List"
    private var list = ArrayList<Pelajaran>()
    private var requestAdapterRecyclerView: ListAdapter? = null
    private var database: DatabaseReference? = null
    private val fab_add: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matapejaran)
        rvData = findViewById(R.id.recyleView)
        rvData.setHasFixedSize(true)
        showRecyclerCardView()
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


    private fun showRecyclerCardView() {
        val cardViewHeroAdapter = ListAdapter(list){pelajaran, i ->
            val it = Intent(this@ActivityMataPelajaran, ActivityDetailPelajaran::class.java)
            it.putExtra("detail", pelajaran.detail)
            it.putExtra("gambar", pelajaran.gambar)
            it.putExtra("nama", pelajaran.Nama)
            startActivity(it)
        }

        rvData.adapter = cardViewHeroAdapter
        //rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvData.layoutManager = GridLayoutManager(this, 2)

        var database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("mata_pelajaran")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val t = object: GenericTypeIndicator<ArrayList<Pelajaran>>(){}
                val value = dataSnapshot.getValue(t)!!
                list.addAll(value)
                cardViewHeroAdapter.notifyDataSetChanged()
                //Log.e("data",Gson().toJson(value))
            }
            override fun onCancelled(error: DatabaseError) { // Failed to read value
            }
        })}
    class pelajaranholder(var mata_pelajaran:ArrayList<Pelajaran>)
    }