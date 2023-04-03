package com.karaev.andrew.appshop

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.view.PreviewView
import androidx.fragment.app.Fragment
import com.karaev.andrew.appshop.authentication.AuthFragment
import com.karaev.andrew.appshop.interfaceCLick.FragmentReplace

class MainActivity : AppCompatActivity(), FragmentReplace {
    lateinit var cameraFrameLAyout: PreviewView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Fragment create----------------------------------------------------------------------
        val currentFargment = supportFragmentManager.findFragmentById(R.id.fragment_container)


        if (currentFargment == null) {
            val fragment = AuthFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
                .commit()
        }
        //--------------------------------------------------------------------------------------

    }

    //Fragment Replace----------------------------------------------------------------------
    override fun fragmentReplaceManager(
        fragment: Fragment,
        addtoBackStatus: Boolean,
    ) {


        when (addtoBackStatus) {
            true -> {
                addFragmentBackButton(fragment)
            }
            false -> {
                addFragment(fragment)
            }
        }


    }

    override fun addFragmentBackButton(fm: Fragment) {
        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.fragment_container, fm).commit()
    }

    override fun addFragment(fm: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fm).commit()
    }




}