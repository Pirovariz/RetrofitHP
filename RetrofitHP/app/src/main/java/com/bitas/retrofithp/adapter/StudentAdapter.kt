package com.bitas.retrofithp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitas.retrofithp.api.ApiData
import com.bitas.retrofithp.databinding.RecyclerLayoutBinding
import com.bumptech.glide.Glide

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    var studentsList: ArrayList<ApiData> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {

        val binding = RecyclerLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        with(holder){
            with(studentsList[position]){
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
        this.studentsList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int =  studentsList.size

    inner class ViewHolder(val binding: RecyclerLayoutBinding) : RecyclerView.ViewHolder(binding.root)


}
