package com.karaev.andrew.appshop.authentication

import android.Manifest
import android.app.Dialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.animation.AnimationUtils
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.karaev.andrew.appshop.CameraXFragment
import com.karaev.andrew.appshop.R
import com.karaev.andrew.appshop.authentication.viewmodel.AuthViewModel
import com.karaev.andrew.appshop.databinding.DialogCustomBinding
import com.karaev.andrew.appshop.databinding.FragmentParttwoBinding
import com.karaev.andrew.appshop.interfaceCLick.FragmentReplace
import com.karaev.andrew.appshop.model.UserModel


const val REQUEST_CODE = 20

class AuthTPartFragment : Fragment() {
    private var fragmentReplace: FragmentReplace? = null

     private val requestPermission = listOf(Manifest.permission.CAMERA)
    private lateinit var binding: FragmentParttwoBinding
    private val viewmodel: AuthViewModel by lazy { ViewModelProvider(this).get(AuthViewModel::class.java) }
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
                showDialog()

            }
            buttonCreate.setOnClickListener {
                buttonCreate.startAnimation(mAlphaAnimation)
                instance.users.passwrod = editTextPassword.text.toString()
                checkData(instance.users)
            }
        }


    }


    fun showDialog() {
        val mAlphaAnimation = AnimationUtils.loadAnimation(context, R.anim.alpha_animation);
        val binding = DialogCustomBinding.inflate(layoutInflater)
        val dialog = Dialog(requireActivity())
        dialog.apply {
            setContentView(binding.root)
            setCancelable(true)
            binding.textviewCamera.setOnClickListener {
                binding.textviewCamera.startAnimation(mAlphaAnimation)
                askPermission()
                dialog.dismiss()
            }
            binding.textviewFile.setOnClickListener {
                binding.textviewFile.startAnimation(mAlphaAnimation)
                dialog.dismiss()
                pickImage.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
            show()
        }


    }
    //------------------------------------------------------------------------------------------------------------------

    fun askPermission() {
         if (ContextCompat.checkSelfPermission(
                 this.requireContext(),
                 Manifest.permission.CAMERA
             ) != PackageManager.PERMISSION_GRANTED
         ) {
             ActivityCompat.requestPermissions(
                 this.requireActivity(),
                 requestPermission.toTypedArray(), 101
             )


         } else {
             fragmentReplace?.fragmentReplaceManager(CameraXFragment(), true)
         }
     }




    val pickImage = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->

        if (uri != null) {
            binding.photoCameraAdd.setImageURI(uri)
            Log.d("PhotoPicker", "Selected URI: $uri")
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        fragmentReplace = null
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