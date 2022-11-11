package com.example.cryptocurrencylistapi.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencylistapi.network.CryptoDetails
import com.example.cryptocurrencylistapi.databinding.ListItemOverviewBinding

class CryptoDetailsAdapter :
    ListAdapter<CryptoDetails, CryptoDetailsAdapter.ViewHolder>(CryptoDetailDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ListItemOverviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: CryptoDetails
        ) {
            binding.cryptoDetail = item
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemOverviewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class CryptoDetailDiffCallback : DiffUtil.ItemCallback<CryptoDetails>() {
    override fun areItemsTheSame(oldItem: CryptoDetails, newItem: CryptoDetails): Boolean {
        return oldItem.rank == newItem.rank
    }

    override fun areContentsTheSame(oldItem: CryptoDetails, newItem: CryptoDetails): Boolean {
        return oldItem == newItem
    }
}