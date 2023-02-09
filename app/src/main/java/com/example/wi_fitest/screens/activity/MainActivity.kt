package com.example.wi_fitest.screens.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wi_fitest.databinding.ActivityMainBinding
import com.example.wi_fitest.screens.fragment.MainFragment
import com.example.wi_fitest.utils.APP
import com.example.wi_fitest.utils.mainReplaceFragment
import com.example.wi_fitest.utils.setFullWindow

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFields()
    }

    private fun initFields() {
        APP = this
        setFullWindow(this)
        mainReplaceFragment(MainFragment(), false)
    }
}


