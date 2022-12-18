package ru.nikitazar.effectivemobile.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nikitazar.effectivemobile.databinding.FragmentListBinding
import ru.nikitazar.effectivemobile.ui.adapter.*
import ru.nikitazar.effectivemobile.ui.utils.SpacingItemDecorator
import ru.nikitazar.effectivemobile.viewModel.MainViewModel

private const val GRID_SPAN_COUNT = 2
private const val ITEM_SPACING = 20

class ListFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        callCategory()
        callBestseller()
        callHomeStore()
        return binding.root
    }

    private fun callCategory() {
        val adapterCategory = CategoryAdapter(object : OnCategoryInteractionListener {
            override fun onCheck(id: Int) {
                viewModel.setCategory(id)
            }
        })
        binding.categories.adapter = adapterCategory

        viewModel.dataCategory.observe(viewLifecycleOwner) { data ->
            adapterCategory.apply {
                notifyDataSetChanged()
                submitList(data)
            }
        }
    }

    private fun callHomeStore() {
        val adapterHomeStore = HomeStoreAdapter()
        binding.homeStoreList.apply {
            adapter = adapterHomeStore
            addItemDecoration(SpacingItemDecorator(ITEM_SPACING))
        }

        viewModel.dataHomeStore.observe(viewLifecycleOwner) { data ->
            adapterHomeStore.submitList(data)
        }
    }

    private fun callBestseller() {
        val adapterBestseller = BestsellerAdapter(object : OnInteractionListener {})
        binding.bestsellerList.apply {
            layoutManager = GridLayoutManager(requireContext(), GRID_SPAN_COUNT)
            adapter = adapterBestseller
            addItemDecoration(SpacingItemDecorator(ITEM_SPACING))
        }

        viewModel.dataBestseller.observe(viewLifecycleOwner) { data ->
            adapterBestseller.submitList(data)
        }
    }
}