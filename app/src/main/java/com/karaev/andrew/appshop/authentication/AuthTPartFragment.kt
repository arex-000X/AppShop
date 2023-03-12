package com.karaev.andrew.appshop.authentication

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.google.android.material.textfield.TextInputEditText
import com.karaev.andrew.appshop.R
import com.karaev.andrew.appshop.authentication.viewmodel.AuthViewModel
import com.karaev.andrew.appshop.model.UserModel
import java.util.*


class AuthTPartFragment : Fragment() {
    lateinit var first_name: TextView
    lateinit var last_name: TextView
    lateinit var passwordInput: TextInputEditText
    lateinit var buttonNewAccount: Button
    lateinit var photoCameraAdd:ImageView
    val viewmodel:AuthViewModel by lazy { ViewModelProvider(this).get(AuthViewModel::class.java)}

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
        val view = inflater.inflate(R.layout.fragment_parttwo, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val instance = AuthTPartFragment.newInstance
        first_name = view.findViewById(R.id.first)
        last_name = view.findViewById(R.id.last)
        passwordInput = view.findViewById(R.id.editTextPassword)
        buttonNewAccount = view.findViewById(R.id.button_create)
        first_name.text = instance.users.firstName
        last_name.text = instance.users.lastName
        photoCameraAdd.setOnClickListener {

        }
        buttonNewAccount.setOnClickListener {
            instance.users.passwrod = passwordInput.text.toString()
            checkData(instance.users)
        }


    }

    fun checkData(model:UserModel) {
            viewmodel.addUser(model)
    }


    companion object newInstance {

        lateinit var users: UserModel

        fun newInstance(model: UserModel) {

            users = model

        }
    }

}