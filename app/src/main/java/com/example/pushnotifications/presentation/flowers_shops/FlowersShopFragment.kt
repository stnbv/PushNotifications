package com.example.pushnotifications.presentation.flowers_shops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pushnotifications.databinding.FragmentFlowersShopBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FlowersShopFragment : Fragment() {

    private lateinit var binding: FragmentFlowersShopBinding

    private val viewModel: FlowersShopViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFlowersShopBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        viewModel.flowersShopsData.observe(viewLifecycleOwner) {
            val customAdapter = FlowersShopsAdapter(it) { onItemClick() }
            binding.flowerShopRecyclerView.adapter = customAdapter
        }

        binding.goToDeviceInfoButton.setOnClickListener {
            findNavController().navigate(FlowersShopFragmentDirections.actionFlowersShopFragmentToDeviceInfoFragment())
        }

        return binding.root
    }

    private fun onItemClick() {
        findNavController().navigate(FlowersShopFragmentDirections.actionFlowersShopFragmentToMainFragment())
    }
}