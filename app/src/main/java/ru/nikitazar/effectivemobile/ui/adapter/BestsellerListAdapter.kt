package ru.nikitazar.effectivemobile.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nikitazar.domain.model.BestsellerSmartphone
import ru.nikitazar.effectivemobile.databinding.CardBestsellerBinding


interface OnInteractionListener {

}

class BestsellerListAdapter(
    private val context: Context,
    private val onInteractionListener: OnInteractionListener,
) : ListAdapter<BestsellerSmartphone, BestsellerViewHolder>(BestsellerDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestsellerViewHolder {
        val binding = CardBestsellerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BestsellerViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: BestsellerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, context)
    }
}

class BestsellerViewHolder(
    private val binding: CardBestsellerBinding,
    private val onInteractionListener: OnInteractionListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(phone: BestsellerSmartphone, context: Context) {
        binding.apply {
            title.text = phone.title
            Log.i("BestsellerViewHolder", phone.title)
        }
    }
}

class BestsellerDiffCallback : DiffUtil.ItemCallback<BestsellerSmartphone>() {
    override fun areItemsTheSame(oldItem: BestsellerSmartphone, newItem: BestsellerSmartphone): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestsellerSmartphone, newItem: BestsellerSmartphone): Boolean {
        return oldItem == newItem
    }
}