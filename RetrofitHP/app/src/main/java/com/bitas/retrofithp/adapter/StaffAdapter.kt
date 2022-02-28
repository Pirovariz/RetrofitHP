package com.bitas.retrofithp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitas.retrofithp.api.ApiData
import com.bitas.retrofithp.databinding.RecyclerLayoutBinding
import com.bumptech.glide.Glide

class StaffAdapter: RecyclerView.Adapter<StaffAdapter.ViewHolder>() {

    var staffList: ArrayList<ApiData> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffAdapter.ViewHolder {

        val binding = RecyclerLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StaffAdapter.ViewHolder, position: Int) {
        with(holder){
            with(staffList[position]){
                Glide
                    .with(binding.root)
                    .load(image)
                    .centerCrop()
                    .into(binding.ivCharacter)
                binding.tvHouse.text = this.house
                binding.tvName.text = this.name
            }
        }
    }

    fun setDatabase(list: ArrayList<ApiData>) {
        this.staffList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int =  staffList.size

    inner class ViewHolder(val binding: RecyclerLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}