package com.example.wi_fitest.screens.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wi_fitest.databinding.ActivityAuthBinding
import com.example.wi_fitest.screens.fragment.SplashFragment
import com.example.wi_fitest.utils.AUTH
import com.example.wi_fitest.utils.authReplaceFragment
import com.example.wi_fitest.utils.setFullWindow

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFields()
    }

    private fun initFields() {
        AUTH = this
        setFullWindow(this)
        authReplaceFragment(SplashFragment(), false)
    }
}
