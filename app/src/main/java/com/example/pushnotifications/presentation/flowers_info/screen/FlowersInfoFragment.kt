package com.example.pushnotifications.presentation.flowers_info.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pushnotifications.databinding.FragmentFlowersInfoBinding
import com.example.pushnotifications.presentation.flowers_info.dialog.FlowersInfoDialogFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class FlowersInfoFragment : Fragment() {

    private lateinit var binding: FragmentFlowersInfoBinding

    private val viewModel: FlowersInfoViewModel by viewModel()

    private val args by navArgs<FlowersInfoDialogFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFlowersInfoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        isFromPush()
        viewModel.flowerData.observe(viewLifecycleOwner) {
            binding.shopNameTextView.text = it.shopName
            val customAdapter = FlowersInfoAdapter(it.flowers) { id -> navToInfoDialog(id) }
            binding.galleryRecyclerView.adapter = customAdapter
        }

        return binding.root
    }

    private fun isFromPush() {
        if (!args.id.isNullOrBlank()) {
            findNavController().navigate(
                FlowersInfoFragmentDirections.actionFlowersInfoFragmentToFlowersInfoDialogFragment(args.id)
            )
        }
    }

    private fun navToInfoDialog(id: String) {
        findNavController().navigate(
            FlowersInfoFragmentDirections.actionFlowersInfoFragmentToFlowersInfoDialogFragment(id)
        )
    }
}