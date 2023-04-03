package com.karaev.andrew.appshop

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.camera.core.CameraProvider
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.karaev.andrew.appshop.databinding.CameraPreviewBinding
import java.util.concurrent.Future

class CameraXFragment:Fragment() {
    private lateinit var binding: CameraPreviewBinding
    val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
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
        binding = CameraPreviewBinding.inflate(layoutInflater)
        val view = binding.root


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    cameraProviderFuture.addListener(Runnable {
        val cameraProvider = cameraProviderFuture.get()
        bindPreview(cameraProvider)
    },ContextCompat.getMainExecutor(requireContext()))


    }

    override fun onDestroy() {
        super.onDestroy()
    }




    fun bindPreview(cameraProvider: ProcessCameraProvider) {
        val viewFinder: PreviewView = binding.viewFinder
        val preview: Preview = Preview.Builder()
            .build()

        val cameraSelector: CameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()
        val imageCapture = ImageCapture.Builder()
            .setTargetRotation(viewFinder.display.rotation)
        .build()
        preview.setSurfaceProvider(viewFinder.getSurfaceProvider())
        cameraProvider.bindToLifecycle(
            this as LifecycleOwner,
            cameraSelector,
            imageCapture,
            preview
        )
    }
}

