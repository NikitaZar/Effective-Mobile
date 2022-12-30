package ru.nikitazar.effectivemobile.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nikitazar.effectivemobile.databinding.CardListBestsellerBinding
import ru.nikitazar.effectivemobile.ui.utils.SpacingItemDecorator

private const val ITEM_SPACING = 20

class BestsellerListAdapter(
    private val adapterBestseller: BestsellerAdapter
) : RecyclerView.Adapter<BestsellerListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CardListBestsellerBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardListBestsellerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.bestsellerList.apply {
            adapter = adapterBestseller
            addItemDecoration(SpacingItemDecorator(ITEM_SPACING))
        }
    }

    override fun getItemCount() = 1
}