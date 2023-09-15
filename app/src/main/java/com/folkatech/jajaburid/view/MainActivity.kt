package com.folkatech.jajaburid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.folkatech.jajaburid.R
import com.folkatech.jajaburid.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View binding initiation
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //View configuration
        initView()





    }

    private fun initView() {
        supportActionBar?.hide()

        // Set up banner top
        val rvbanner =  binding.rvHomeBanner
        val bannerData = arrayListOf(R.drawable.banner1,R.drawable.banner2,R.drawable.banner3,R.drawable.banner4)
        val adapter = BannerAdapter(bannerData)
        val snapHelper = LinearSnapHelper()
        rvbanner.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvbanner.adapter = adapter
        snapHelper.attachToRecyclerView(rvbanner)

        //Bottom bar configuration
        BottomSheetBehavior.from(binding.bottomBar).apply {
            peekHeight = 250
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

}