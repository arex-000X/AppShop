package com.karaev.andrew.appshop.authentication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.karaev.andrew.appshop.R
import com.karaev.andrew.appshop.interfaceCLick.FragmentReplace
import com.karaev.andrew.appshop.authentication.viewmodel.AuthViewModel
import com.karaev.andrew.appshop.databinding.FragmentAuthBinding
import com.karaev.andrew.appshop.model.UserModel


class AuthFragment : Fragment() {
    private lateinit var binding:FragmentAuthBinding
    private var fragmentReplace: FragmentReplace? = null
    lateinit var viewmodel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentReplace = context as FragmentReplace?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mAlphaAnimation = AnimationUtils.loadAnimation(context, R.anim.alpha_animation)
        viewmodel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.apply {

            textViewLogin.setOnClickListener {
                val loginFragment = LoginFragment()
                fragmentReplace?.fragmentReplaceManager(loginFragment, true)
            }


            buttonSignin.setOnClickListener {
                buttonSignin.startAnimation(mAlphaAnimation)

                when {
                    editTextFirstName.text.toString().length == 0 -> {

                        editTextLastName.setError("Поле пустое")

                    }
                    editTextLastName.text.toString().length == 0 -> {

                        editTextLastName.setError("Поле пустое")


                    }
                    editTextEmail.text.toString().length == 0 -> {
                        editTextLastName.setError("Поле пустое")
                    }
                    else -> {
                        val model = UserModel(
                            firstName = editTextFirstName.text.toString(),
                            lastName = editTextLastName.text.toString(),
                            mail = editTextEmail.text.toString()
                        )
                        val authTPartFragment = AuthTPartFragment()
                        fragmentReplace?.fragmentReplaceManager(authTPartFragment, true)
                        AuthTPartFragment.newInstance(model)
                    }
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentReplace = null
    }


}

