package ru.nikitazar.effectivemobile.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nikitazar.effectivemobile.databinding.FragmentListBinding
import ru.nikitazar.effectivemobile.ui.adapter.BestsellerListAdapter
import ru.nikitazar.effectivemobile.ui.adapter.OnInteractionListener
import ru.nikitazar.effectivemobile.viewModel.MainViewModel

class ListFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentListBinding.inflate(inflater, container, false)

        val adapter = BestsellerListAdapter(requireContext(), object : OnInteractionListener {})

        binding.bestsellerList.adapter = adapter

        viewModel.dataBestseller.observe(viewLifecycleOwner) { data ->
            Log.i("dataBestseller", data.size.toString())
            adapter.submitList(data)
        }

        return binding.root
    }

}