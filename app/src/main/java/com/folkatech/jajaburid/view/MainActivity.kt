package com.folkatech.jajaburid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.folkatech.jajaburid.R
import com.folkatech.jajaburid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View binding initiation
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup view
        supportActionBar?.hide()

        setUpBannerView()


    }

    private fun setUpBannerView() {
        val rvbanner =  binding.rvHomeBanner
        val bannerData = arrayListOf(R.drawable.banner1,R.drawable.banner2,R.drawable.banner3,R.drawable.banner4)
        val adapter = BannerAdapter(bannerData)
        val snapHelper = LinearSnapHelper()
        rvbanner.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvbanner.adapter = adapter
        snapHelper.attachToRecyclerView(rvbanner)
    }
}