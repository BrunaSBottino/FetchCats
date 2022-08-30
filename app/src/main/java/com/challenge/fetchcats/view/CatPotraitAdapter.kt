package com.challenge.fetchcats.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.challenge.fetchcats.databinding.ItemCatImageBinding

class CatPotraitAdapter(val linksList: List<String>) : RecyclerView.Adapter<CatPotraitAdapter.CatViewHolder>() {

    class CatViewHolder(val binding: ItemCatImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatViewHolder {
        return CatViewHolder(ItemCatImageBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        Glide.with(holder.binding.imageViewCat).load(linksList[position]).into(holder.binding.imageViewCat)
    }

    override fun getItemCount(): Int = linksList.size
}