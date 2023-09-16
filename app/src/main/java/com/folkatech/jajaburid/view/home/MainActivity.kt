package com.folkatech.jajaburid.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.folkatech.jajaburid.R
import com.folkatech.jajaburid.data.network.FoodResponseItem
import com.folkatech.jajaburid.data.network.Resource
import com.folkatech.jajaburid.databinding.ActivityMainBinding
import com.folkatech.jajaburid.view.detail.DetailActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel: HomeViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View binding initiation
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //View configuration
        initView()

        //Data integration
        getData()




    }

    private fun getData() {
        homeViewModel.data.observe(this){
            if(it != null){
                when (it){
                    is Resource.Loading -> {
                        //Shimmer layout on
                        binding.shimmer.visibility = View.VISIBLE
                        binding.shimmer.startShimmer()
                    }
                    is Resource.Success -> {
                        binding.shimmer.visibility = View.GONE
                        Log.d("TAG", "onCreate: ${it.data?.size}")
                        showData(it.data)

                    }
                    is Resource.Error -> {
                        Log.d("TAG", "onCreate: Error boss")
                    }
                }
            }
        }
    }

    private fun showData(data: List<FoodResponseItem?>?) {
        val rvFood = binding.rvListFood
        val adapter = FoodAdapter(this, data)
        rvFood.layoutManager = GridLayoutManager(this, 2)
        rvFood.adapter = adapter
        adapter.setOnItemClickCallback(object : FoodAdapter.OnItemClickCallback{
            override fun onItemClicked(data: FoodResponseItem?) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("data", data)
                startActivity(intent)
            }
        })
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