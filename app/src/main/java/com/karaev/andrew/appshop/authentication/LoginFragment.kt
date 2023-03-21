package com.karaev.andrew.appshop.authentication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.fragment.app.Fragment
import com.karaev.andrew.appshop.R

class LoginFragment():Fragment() {
lateinit var buttonCreate:Button


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
       val view = inflater.inflate(R.layout.fragment_login,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mAlphaAnimation =   AnimationUtils.loadAnimation(context,R.anim.alpha_animation);
        buttonCreate = view.findViewById(R.id.button_create)
        buttonCreate.setOnClickListener {
            buttonCreate.startAnimation(mAlphaAnimation)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
    }



}