package com.challenge.fetchcats.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.challenge.fetchcats.MainViewModel
import com.challenge.fetchcats.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getCatImageLinks(){
            runOnUiThread{
                setupAdapter(it)
            }
        }
    }

    private fun setupAdapter(links: List<String>) {
        binding.recyclerViewCatPortrait.adapter = CatPotraitAdapter(links)
        binding.recyclerViewCatPortrait.layoutManager = GridLayoutManager(this@MainActivity, 3)
    }
}