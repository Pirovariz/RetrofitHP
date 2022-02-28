package com.bitas.retrofithp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bitas.retrofithp.R
import com.bitas.retrofithp.adapter.StudentAdapter
import com.bitas.retrofithp.api.ApiData
import com.bitas.retrofithp.databinding.FragmentStudentBinding
import com.bitas.retrofithp.util.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class StudentFragment : Fragment() {

    lateinit var binding: FragmentStudentBinding

    val adapter = StudentAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentStudentBinding.inflate(layoutInflater)
        setupRecyclerView()
        getApiData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    fun getApiData(){
        val retrofit = Retrofit.create()
        CoroutineScope(Dispatchers.IO).launch{
            val studentList = retrofit.getStudent()
            setDataBase(studentList)

        }
    }
    fun setDataBase(studentList:ArrayList<ApiData>) {

        CoroutineScope(Dispatchers.Main).launch{
            adapter.setDatabase(studentList)
        }
    }

    fun setupRecyclerView(){
        binding.rvStudent.adapter = adapter
    }


}