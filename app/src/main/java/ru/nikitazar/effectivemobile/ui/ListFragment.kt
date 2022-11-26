package ru.nikitazar.effectivemobile.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nikitazar.effectivemobile.databinding.FragmentListBinding
import ru.nikitazar.effectivemobile.ui.adapter.BestsellerAdapter
import ru.nikitazar.effectivemobile.ui.adapter.HomeStoreAdapter
import ru.nikitazar.effectivemobile.ui.adapter.OnInteractionListener
import ru.nikitazar.effectivemobile.ui.utils.SpacingItemDecorator
import ru.nikitazar.effectivemobile.viewModel.MainViewModel

const val ITEM_SPACING = 20

class ListFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentListBinding.inflate(inflater, container, false)

        val adapterHomeStore = HomeStoreAdapter()
        val adapterBestseller = BestsellerAdapter(object : OnInteractionListener {})

        binding.homeStoreList.adapter = adapterHomeStore
        binding.homeStoreList.addItemDecoration(
            SpacingItemDecorator(ITEM_SPACING)
        )

        viewModel.dataHomeStore.observe(viewLifecycleOwner) { data ->
            adapterHomeStore.submitList(data)
        }

        viewModel.dataBestseller.observe(viewLifecycleOwner) { data ->
            adapterBestseller.submitList(data)
        }

        return binding.root
    }

}