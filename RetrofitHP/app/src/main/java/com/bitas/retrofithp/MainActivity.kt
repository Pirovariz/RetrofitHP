package com.bitas.retrofithp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitas.retrofithp.adapter.ViewPagerAdapter
import com.bitas.retrofithp.databinding.ActivityMainBinding
import com.bitas.retrofithp.fragments.StaffFragment
import com.bitas.retrofithp.fragments.StudentFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(StudentFragment(), "Student")
        adapter.addFragment(StaffFragment(), "Staff")
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.tabLayout.getTabAt(0)

    }
}