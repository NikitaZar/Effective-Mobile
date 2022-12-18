package ru.nikitazar.effectivemobile.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nikitazar.domain.model.Category
import ru.nikitazar.effectivemobile.R
import ru.nikitazar.effectivemobile.databinding.CardCategoryBinding

interface OnCategoryInteractionListener {
    fun onCheck(id: Int)
}

class CategoryAdapter(
    private val onInteractionListener: OnCategoryInteractionListener
) : ListAdapter<Category, CategoryViewHolder>(CategoryDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CardCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class CategoryViewHolder(
    private val binding: CardCategoryBinding, private val onInteractionListener: OnCategoryInteractionListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(category: Category) {
        with(binding) {
            val context = root.context
            val resources = context.resources

            text.text = category.text
            text.setTextColor(resources.getColorStateList(R.color.color_category_text_state, context.theme))
            text.isChecked = category.isChecked

            val iconRes = ResourcesCompat.getDrawable(binding.root.context.resources, category.icon, null)
            icon.setImageDrawable(iconRes)
            when (category.isChecked) {
                true -> icon.setColorFilter(resources.getColor(R.color.white, context.theme))
                false -> icon.setColorFilter(resources.getColor(R.color.light_gray, context.theme))
            }


            iconBackground.backgroundTintList = resources.getColorStateList(R.color.color_category_background_state, context.theme)
            iconBackground.isSelected = category.isChecked

            icon.setOnClickListener {
                onInteractionListener.onCheck(category.id)
            }
        }
    }
}

class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Category, newItem: Category) = oldItem.id == newItem.id
}