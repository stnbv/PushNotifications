package com.example.pushnotifications.presentation.flowers_info.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.pushnotifications.R
import com.example.pushnotifications.databinding.DialogFlowersInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FlowersInfoDialogFragment : DialogFragment() {

    private lateinit var binding: DialogFlowersInfoBinding

    private val viewModel: FlowersInfoDialogViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogFlowersInfoBinding.inflate(inflater, container, false)

        viewModel.flowerData.observe(viewLifecycleOwner) {
            if (it == null) {
                dismiss()
            } else {
                with(binding) {
                    priceTextView.text = getString(R.string.flowers_price, it.price)
                    deliveryPriceTextView.text = getString(R.string.flowers_delivery_price, it.deliveryPrice)
                    titleTextView.text = it.bouquetName
                }
            }
        }

        return binding.root
    }
}