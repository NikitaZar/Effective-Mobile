package ru.nikitazar.effectivemobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nikitazar.effectivemobile.databinding.FragmentListBinding
import ru.nikitazar.effectivemobile.ui.adapter.BestsellerAdapter
import ru.nikitazar.effectivemobile.ui.adapter.HomeStoreAdapter
import ru.nikitazar.effectivemobile.ui.adapter.OnInteractionListener
import ru.nikitazar.effectivemobile.ui.utils.GridSpacingItemDecoration
import ru.nikitazar.effectivemobile.ui.utils.SpacingItemDecorator
import ru.nikitazar.effectivemobile.viewModel.MainViewModel

private const val GRID_SPAN_COUNT = 2
private const val ITEM_SPACING = 20

class ListFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentListBinding.inflate(inflater, container, false)

        //Home Store
        val adapterHomeStore = HomeStoreAdapter()
        binding.homeStoreList.apply {
            adapter = adapterHomeStore
            addItemDecoration(SpacingItemDecorator(ITEM_SPACING))
        }

        viewModel.dataHomeStore.observe(viewLifecycleOwner) { data ->
            adapterHomeStore.submitList(data)
        }

        //Bestseller
        val adapterBestseller = BestsellerAdapter(object : OnInteractionListener {})
        binding.bestsellerList.apply {
            layoutManager = GridLayoutManager(requireContext(), GRID_SPAN_COUNT)
            adapter = adapterBestseller
            addItemDecoration(SpacingItemDecorator(ITEM_SPACING))
        }

        viewModel.dataBestseller.observe(viewLifecycleOwner) { data ->
            adapterBestseller.submitList(data)
        }

        return binding.root
    }
}