package com.bitas.retrofithp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bitas.retrofithp.R
import com.bitas.retrofithp.adapter.StaffAdapter
import com.bitas.retrofithp.adapter.StudentAdapter
import com.bitas.retrofithp.api.ApiData
import com.bitas.retrofithp.databinding.FragmentStaffBinding
import com.bitas.retrofithp.databinding.FragmentStudentBinding
import com.bitas.retrofithp.util.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StaffFragment : Fragment() {

    lateinit var binding: FragmentStaffBinding

    val adapter = StaffAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentStaffBinding.inflate(layoutInflater)
        setupRecyclerView()
        getApiData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    fun getApiData() {
        val retrofit = Retrofit.create()
        CoroutineScope(Dispatchers.IO).launch {
            val staffList = retrofit.getStaff()
            setDataBase(staffList)
        }
    }

    fun setDataBase(staffList:ArrayList<ApiData>) {

        CoroutineScope(Dispatchers.Main).launch{
            adapter.setDatabase(staffList)
        }
    }
    fun setupRecyclerView(){
        binding.rvStaff.adapter = adapter
    }
}