package com.folkatech.jajaburid.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.folkatech.jajaburid.R
import com.folkatech.jajaburid.data.network.FoodResponseItem
import com.folkatech.jajaburid.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View binding initiation
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Receive data from main activity and integrate it into the detail activity views
        handleDataFromMain()

        //Button back and chart integration
        binding.btnChart.setOnClickListener {
            Toast.makeText(this,"This feature is still under development",Toast.LENGTH_SHORT).show()
        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun handleDataFromMain() {
        val food = intent.getParcelableExtra<FoodResponseItem?>("data")
        binding.tvTitleDetail.text = food?.name.toString()
        binding.tvPriceDetail.text = getString(R.string.rp, food?.price)
        binding.tvDescDetail.text = food?.desc
        Glide.with(this)
            .load(food?.cover)
            .error(R.drawable.bg_bottom_bar)
            .into(binding.ivPhotoDetail)
    }
}