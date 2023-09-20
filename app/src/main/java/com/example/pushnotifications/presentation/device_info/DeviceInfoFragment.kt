package com.example.pushnotifications.presentation.device_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pushnotifications.R
import com.example.pushnotifications.databinding.FragmentDeviceInfoBinding
import com.example.pushnotifications.utils.copyToClipboard
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeviceInfoFragment : Fragment() {

    private lateinit var binding: FragmentDeviceInfoBinding

    private val viewModel: DeviceInfoViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDeviceInfoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        binding.udidTextView.copyOnClick()
        binding.fcmTokenTextView.copyOnClick()

        return binding.root
    }

    private fun TextView.copyOnClick() {
        this.setOnClickListener {
            val text = this.text.toString()
            requireContext().copyToClipboard(text)
            Toast.makeText(context, R.string.copy, Toast.LENGTH_SHORT).show()
        }
    }
}