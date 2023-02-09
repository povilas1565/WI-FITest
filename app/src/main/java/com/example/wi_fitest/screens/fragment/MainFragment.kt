package com.example.wi_fitest.screens.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.fragment.app.Fragment
import com.example.wi_fitest.databinding.FragmentMainBinding
import com.example.wi_fitest.utils.authReplaceFragment
import com.example.wi_fitest.utils.hideBottomNav
import com.example.wi_fitest.utils.replaceFragment
import com.google.android.material.slider.RangeSlider

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initFields()
        initFuns()
    }

    private fun initFields() {
        hideBottomNav()
    }

    private fun initFuns() {
        binding.helpBtn.setOnClickListener {
            binding.alphaBg.visibility = View.VISIBLE
            binding.helpView.visibility = View.VISIBLE
        }

        binding.authBtn.setOnClickListener {
            authReplaceFragment(AuthFragment(), false)
        }

        binding.signupBtn.setOnClickListener {
            authReplaceFragment(SignupFragment(), false)
        }
        }

    @InverseBindingAdapter(attribute = "values")
    fun getRangeSlider(slider: RangeSlider): List<Float> {
        return slider.values
    }

    @BindingAdapter("app:valuesAttrChanged")
    fun setListeners(
        slider: RangeSlider,
        attrChange: InverseBindingListener
    ) {
        val listener = RangeSlider.OnChangeListener { _, _, _ -> attrChange.onChange() }
        slider.addOnChangeListener(listener)
    }
    }
