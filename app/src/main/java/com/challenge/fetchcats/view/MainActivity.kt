package com.challenge.fetchcats.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.challenge.fetchcats.viewModel.MainViewModel
import com.challenge.fetchcats.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObserver()
        viewModel.getCatImageLinks()
    }

    private fun setupObserver() {
        viewModel.imageLinks.observe(this){
            setupAdapter(it)
        }
    }

    private fun setupAdapter(links: List<String>) {
        binding.recyclerViewCatPortrait.adapter = CatPotraitAdapter(links)
        binding.recyclerViewCatPortrait.layoutManager = GridLayoutManager(this@MainActivity, 4)
    }
}