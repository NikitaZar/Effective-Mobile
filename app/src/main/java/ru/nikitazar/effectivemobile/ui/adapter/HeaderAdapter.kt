package ru.nikitazar.effectivemobile.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nikitazar.effectivemobile.databinding.CardHeaderBinding

interface OnHeaderInteractionListener {
    fun onFilter()
}

class HeaderAdapter(
    private val adapterCategory: CategoryAdapter,
    private val onHeaderInteractionListener: OnHeaderInteractionListener
) : RecyclerView.Adapter<HeaderAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CardHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardHeaderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            categories.adapter = adapterCategory

            btFilter.setOnClickListener {
                onHeaderInteractionListener.onFilter()
            }
        }
    }

    override fun getItemCount() = 1
}