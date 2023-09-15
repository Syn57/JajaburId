package com.folkatech.jajaburid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.folkatech.jajaburid.R

class BannerAdapter (private val photo: ArrayList<Int>): RecyclerView.Adapter<BannerAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_banner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = photo.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val idPhoto = photo[position]
        holder.imgPhoto.setImageResource(idPhoto)
    }
}