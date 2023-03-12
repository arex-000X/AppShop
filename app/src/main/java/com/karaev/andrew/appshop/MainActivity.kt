package com.karaev.andrew.appshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.karaev.andrew.appshop.authentication.AuthFragment
import com.karaev.andrew.appshop.interfaceCLick.CallBackClick

class MainActivity : AppCompatActivity(), CallBackClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val currentFargment = supportFragmentManager.findFragmentById(R.id.fragment_container)


        if (currentFargment == null) {
            val fragment = AuthFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
                .commit()
        }


    }

    override fun onClick(fragment: Fragment,addtoBackStatus:Boolean) {

        when (addtoBackStatus) {
            true -> {

                supportFragmentManager.beginTransaction().addToBackStack(null)
                    .replace(R.id.fragment_container, fragment).commit()

            }
            false -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment).commit()
            }
        }

    }


}