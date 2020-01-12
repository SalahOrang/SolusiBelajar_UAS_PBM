package com.example.uass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uass.Model.Soal
import kotlinx.android.synthetic.main.detailsoal.view.*

class MakanAdapter(
    var pelajaran: ArrayList<Soal>,
    var clik: (Soal, Int)-> Unit
) : RecyclerView.Adapter<MakanAdapter.ViewHolder>() {


    fun updatePhotos(newPhotos: List<Soal>) {
        pelajaran.clear()
        pelajaran.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.detailsoal, parent, false)
        )

    override fun getItemCount() = pelajaran.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pelajaran[position],clik,position)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(soal: Soal, onClick: (Soal, Int) -> Unit, i:Int) {
            itemView.nomersoal.text =soal.id
            itemView.textsoal.text = soal.soal
            itemView.pilgana.text = soal.a
            itemView.pilganb.text = soal.b
            itemView.pilganc.text = soal.c
            itemView.pilgand.text =soal.d

            //itemView.setOnClickListener {
             //   onClick.invoke(pelajaran,i)



        }
    }
}
