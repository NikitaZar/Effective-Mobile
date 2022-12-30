package ru.nikitazar.effectivemobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nikitazar.effectivemobile.databinding.FragmentListBinding
import ru.nikitazar.effectivemobile.ui.adapter.*
import ru.nikitazar.effectivemobile.ui.utils.SpacingItemDecorator
import ru.nikitazar.effectivemobile.viewModel.MainViewModel


private const val ITEM_SPACING = 20

class ListFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var binding: FragmentListBinding
    private val adapterCategory = CategoryAdapter(object : OnCategoryInteractionListener {
        override fun onCheck(id: Int) {
            viewModel.setCategory(id)
        }
    })
    private val adapterBestseller = BestsellerAdapter(object : OnInteractionListener {})
    private val adapterHomeStore = HomeStoreAdapter()
    private val headerAdapter = HeaderAdapter(adapterCategory)
    private val adapterListBestseller = BestsellerListAdapter(adapterBestseller)
    private val adapterListHomeStore = HomeStoreListAdapter(adapterHomeStore)
    private val concatAdapter = ConcatAdapter(
        headerAdapter,
        adapterListHomeStore,
        adapterListBestseller
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        bind()
        subscribers()
        return binding.root
    }

    private fun bind() {
        binding.list.adapter = concatAdapter
    }

    private fun subscribers() {
        viewModel.apply {
            dataCategory.observe(viewLifecycleOwner) { data ->
                adapterCategory.apply {
                    notifyDataSetChanged()
                    submitList(data)
                }
            }
            dataHomeStore.observe(viewLifecycleOwner) { data ->
                adapterHomeStore.submitList(data)
            }
            dataBestseller.observe(viewLifecycleOwner) { data ->
                adapterBestseller.submitList(data)
            }
        }
    }
}