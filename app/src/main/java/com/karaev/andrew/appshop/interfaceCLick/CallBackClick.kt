package com.karaev.andrew.appshop.interfaceCLick

import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

interface CallBackClick {
    fun onClick(fragment: Fragment,addtoBackStatus:Boolean)
}