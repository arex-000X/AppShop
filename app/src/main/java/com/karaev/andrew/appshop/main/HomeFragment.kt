package com.karaev.andrew.appshop.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.karaev.andrew.appshop.R
import com.karaev.andrew.appshop.interfaceCLick.CallBackClick
import com.karaev.andrew.appshop.main.fragment.LikeFragment
import com.karaev.andrew.appshop.main.fragment.MessageFragment
import com.karaev.andrew.appshop.main.fragment.PersonFragment
import com.karaev.andrew.appshop.main.fragment.ShopFragment

class HomeFragment:Fragment() {
    lateinit var bottomnav:BottomNavigationView
    val callBackClick = context as CallBackClick?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view = inflater.inflate(R.layout.fragment_home,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomnav = view.findViewById(R.id.bottomNav)
        bottomnav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.page_1 -> callBackClick?.onClick(HomeFragment(),false)
                R.id.page_2 -> callBackClick?.onClick(LikeFragment(),false)
                R.id.page_3 -> callBackClick?.onClick(ShopFragment(),false)
                R.id.page_4 -> callBackClick?.onClick(MessageFragment(),false)
                R.id.page_5 -> callBackClick?.onClick(PersonFragment(),false)
            }
            return@setOnItemSelectedListener true
        }


    }
}