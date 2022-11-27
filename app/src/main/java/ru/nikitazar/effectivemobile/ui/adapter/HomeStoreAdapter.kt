package ru.nikitazar.effectivemobile.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nikitazar.domain.model.HomeStoreSmartphone
import ru.nikitazar.effectivemobile.databinding.CardHomeStoreBinding
import ru.nikitazar.effectivemobile.ui.utils.load

class HomeStoreAdapter(
) : ListAdapter<HomeStoreSmartphone, HomeStoreViewHolder>(HomeStoreDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoreViewHolder {
        val binding = CardHomeStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeStoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeStoreViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class HomeStoreViewHolder(
    private val binding: CardHomeStoreBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(phone: HomeStoreSmartphone) {
        with(binding) {
            title.text = phone.title
            subtitle.text = phone.subtitle
            image.load(phone.picture)
            icNew.isVisible = phone.isNew

            btBuy.transformationMethod = null
        }
    }
}

class HomeStoreDiffCallback : DiffUtil.ItemCallback<HomeStoreSmartphone>() {
    override fun areItemsTheSame(oldItem: HomeStoreSmartphone, newItem: HomeStoreSmartphone) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: HomeStoreSmartphone, newItem: HomeStoreSmartphone) = oldItem == newItem
}