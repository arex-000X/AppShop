package com.karaev.andrew.appshop.authentication

import android.content.Context
import android.os.Bundle
import android.service.autofill.RegexValidator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.karaev.andrew.appshop.R
import com.karaev.andrew.appshop.interfaceCLick.CallBackClick
import com.karaev.andrew.appshop.authentication.viewmodel.AuthViewModel
import com.karaev.andrew.appshop.main.HomeFragment
import com.karaev.andrew.appshop.model.UserModel
import java.util.*


class AuthFragment : Fragment() {

    lateinit var editTextFirstName: EditText
    lateinit var editTextLastName: EditText
    lateinit var editTextMail: EditText
    lateinit var textViewLogin: TextView
    lateinit var buttonSignIn: TextView
    private var callBackClick: CallBackClick? = null

    lateinit var viewmodel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callBackClick = context as CallBackClick?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_auth, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(this).get(AuthViewModel::class.java)
        buttonSignIn = view.findViewById(R.id.button_signin)
        editTextFirstName = view.findViewById(R.id.editTextFirstName)
        editTextLastName = view.findViewById(R.id.editTextLastName)
        editTextMail = view.findViewById(R.id.editTextEmail)
        textViewLogin = view.findViewById(R.id.textView_login)
        textViewLogin.setOnClickListener {
            val loginFragment = LoginFragment()
            callBackClick?.onClick(loginFragment, true)
        }

        buttonSignIn.setOnClickListener {


            when {
                editTextFirstName.text.toString().length == 0 -> {
                    editTextLastName.setError("Поле пустое")
                }
                editTextLastName.text.toString().length == 0 -> {
                    editTextLastName.setError("Поле пустое")

                }
                editTextMail.text.toString().length == 0 -> {
                    editTextMail.setError("Поле пустое")
                }
                else -> {

                    val model = UserModel(
                        firstName = editTextFirstName.text.toString(),
                        lastName = editTextLastName.text.toString(),
                        mail = editTextMail.text.toString()
                    )
                    val authTPartFragment = AuthTPartFragment()
                    callBackClick?.onClick(authTPartFragment, true)
                    AuthTPartFragment.newInstance(model)
                    }
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        callBackClick = null
    }





}

