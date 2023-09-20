package com.example.pushnotifications.presentation.flowers_info.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pushnotifications.R
import com.example.pushnotifications.databinding.ItemFlowerBinding
import com.example.pushnotifications.domain.models.FlowerModel
import com.example.pushnotifications.presentation.flowers_info.screen.FlowersInfoAdapter.ViewHolder

class FlowersInfoAdapter(
    private val data: List<FlowerModel>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(val binding: ItemFlowerBinding) : RecyclerView.ViewHolder(binding.root) {
        val flowerImageView: ImageView get() = binding.flowerImageView
        val titleTextView: TextView get() = binding.titleTextView
        val priceTextView: TextView get() = binding.priceTextView
        val deliveryPriceTextView: TextView get() = binding.deliveryPriceTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFlowerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.flowerImageView.setOnClickListener {
            onClick.invoke(data[position].id)
        }
        Glide.with(viewHolder.binding.root)
            .load(data[position].bouquetImage)
            .placeholder(R.color.purple)
            .into(viewHolder.flowerImageView)

        viewHolder.titleTextView.text = data[position].bouquetName
        viewHolder.priceTextView.text =
            viewHolder.binding.root.context.getString(R.string.flowers_price, data[position].price)
        viewHolder.deliveryPriceTextView.text =
            viewHolder.binding.root.context.getString(R.string.flowers_delivery_price, data[position].deliveryPrice)
    }

    override fun getItemCount() = data.size
}
