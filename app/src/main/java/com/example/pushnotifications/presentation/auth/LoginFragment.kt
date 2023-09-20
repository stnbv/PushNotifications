package com.example.pushnotifications.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pushnotifications.R
import com.example.pushnotifications.databinding.FragmentAuthBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAuthBinding.inflate(layoutInflater)

        binding.loginButton.setOnClickListener {
            this.findNavController().navigate(R.id.action_loginFragment_to_flowersShopFragment)
        }

        viewModel.sendUserDeviceInfo()
        return binding.root
    }
}