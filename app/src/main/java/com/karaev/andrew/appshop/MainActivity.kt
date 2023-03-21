package com.karaev.andrew.appshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.fragment.app.Fragment
import com.karaev.andrew.appshop.authentication.AuthFragment
import com.karaev.andrew.appshop.interfaceCLick.FragmentReplace
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner

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
    override fun fragmentReplaceManager(fragment: Fragment,addtoBackStatus:Boolean,) {
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


    //-------------------------------------------------------------------------------------
    //Camera create------------------------------------------------------------------------




}