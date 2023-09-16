package com.folkatech.jajaburid.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.folkatech.jajaburid.R
import com.folkatech.jajaburid.data.network.FoodResponseItem

class FoodAdapter(private val context: Context, private val data: List<FoodResponseItem?>?) :
    RecyclerView.Adapter<FoodAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: FoodResponseItem?)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.iv_photo_food)
        val foodName: TextView = itemView.findViewById(R.id.tv_title_food)
        val price: TextView = itemView.findViewById(R.id.tv_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val cover = data?.get(position)?.cover
        val price = data?.get(position)?.price
        val name = data?.get(position)?.name
        Glide.with(context)
            .load(cover)
            .error(R.drawable.bg_bottom_bar)
            .into(holder.img)
        holder.foodName.text = name
        holder.price.text = context.getString(R.string.rp, price)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(data?.get(holder.adapterPosition)) }
    }

    override fun getItemCount(): Int = data?.size ?: 0
}