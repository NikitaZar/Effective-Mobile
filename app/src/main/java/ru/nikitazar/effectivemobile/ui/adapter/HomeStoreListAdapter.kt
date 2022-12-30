package ru.nikitazar.effectivemobile.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nikitazar.effectivemobile.databinding.CardListHomeStoreBinding
import ru.nikitazar.effectivemobile.ui.utils.SpacingItemDecorator

private const val ITEM_SPACING = 20

class HomeStoreListAdapter(
    private val adapterHomeStore: HomeStoreAdapter
) : RecyclerView.Adapter<HomeStoreListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CardListHomeStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoreListAdapter.ViewHolder {
        return ViewHolder(
            CardListHomeStoreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.homeStoreList.apply {
            adapter = adapterHomeStore
            addItemDecoration(SpacingItemDecorator(ITEM_SPACING))
        }
    }

    override fun getItemCount() = 1
}