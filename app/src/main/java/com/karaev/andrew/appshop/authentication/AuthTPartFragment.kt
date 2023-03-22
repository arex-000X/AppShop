package com.karaev.andrew.appshop.authentication

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.Manifest.permission.CAMERA
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.karaev.andrew.appshop.R
import com.karaev.andrew.appshop.authentication.viewmodel.AuthViewModel
import com.karaev.andrew.appshop.databinding.FragmentParttwoBinding
import com.karaev.andrew.appshop.interfaceCLick.FragmentReplace
import com.karaev.andrew.appshop.model.UserModel

const val REQUEST_CODE = 20

class AuthTPartFragment : Fragment() {
    private var activivtyReplace: FragmentReplace? = null
    private val requestPermission = listOf(CAMERA)
    lateinit var binding:FragmentParttwoBinding
    private val viewmodel: AuthViewModel by lazy { ViewModelProvider(this).get(AuthViewModel::class.java) }

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
    ): View {
        binding = FragmentParttwoBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val instance = AuthTPartFragment.newInstance
        binding.apply {

            val mAlphaAnimation = AnimationUtils.loadAnimation(context, R.anim.alpha_animation);
            firstName.text = instance.users.firstName
            lastName.text = instance.users.lastName
            photoCameraAdd.setOnClickListener {
                photoCameraAdd.startAnimation(mAlphaAnimation)
               askPermission()
            }
            buttonCreate.setOnClickListener {
                buttonCreate.startAnimation(mAlphaAnimation)
                instance.users.passwrod = editTextPassword.text.toString()
                checkData(instance.users)
            }
        }



    }

fun askPermission(){
    if(ContextCompat.checkSelfPermission(this.requireContext(),CAMERA) != PackageManager.PERMISSION_GRANTED ){
        ActivityCompat.requestPermissions(this.requireActivity(),
            requestPermission.toTypedArray(),101)
    } else{
        openCamera()
    }
}

    fun openCamera(){
        val intent = Intent()
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }



    override fun onDestroy() {
        super.onDestroy()

    }

    fun checkData(model: UserModel) {
        viewmodel.addUser(model)
    }


    companion object newInstance {

        lateinit var users: UserModel

        fun newInstance(model: UserModel) {

            users = model

        }
    }

}