package com.example.wi_fitest.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.wi_fitest.R

fun replaceFragment(fragment: Fragment, backStack: Boolean = true) {
    APP.binding.bottomNav.visibility = View.VISIBLE
    if (backStack) {
        APP.supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.fragment_frame, fragment)
            .addToBackStack(null)
            .commit()
    } else {
        APP.supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.fragment_frame, fragment)
            .commit()
    }
}

fun mainReplaceFragment(fragment: Fragment, backStack: Boolean = true) {
    APP.binding.bottomNav.visibility = View.GONE
    if (backStack) {
        APP.supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.fragment_frame, fragment)
            .addToBackStack(null)
            .commit()
    } else {
        APP.supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.fragment_frame, fragment)
            .commit()
    }
}

fun authReplaceFragment(fragment: Fragment, backStack: Boolean = true) {
    if (backStack) {
        AUTH.supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.auth_frame, fragment)
            .addToBackStack(null)
            .commit()
    } else {
        AUTH.supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.auth_frame, fragment)
            .commit()
    }
}

fun setFullWindow(activity: AppCompatActivity) {
    if (Build.VERSION.SDK_INT in 19..20) {
        setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
    }
    activity.window.decorView.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
    activity.window.statusBarColor = Color.TRANSPARENT
}

private fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
    val win: Window = activity.window
    val winParams: WindowManager.LayoutParams = win.attributes
    if (on) {
        winParams.flags = winParams.flags or bits
    } else {
        winParams.flags = winParams.flags and bits.inv()
    }
    win.attributes = winParams
}

fun hideBottomNav() {
    APP.binding.bottomNav.visibility = View.GONE
}

