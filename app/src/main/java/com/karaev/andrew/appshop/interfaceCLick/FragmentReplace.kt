package com.karaev.andrew.appshop.interfaceCLick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

interface FragmentReplace {
    fun fragmentReplaceManager(fragment: Fragment, addtoBackStatus:Boolean)
    fun addFragmentBackButton(fm:Fragment)
    fun addFragment(fm:Fragment)
 // метод в разработке  fun activityReplaceManager(classIntent: Intent)
}