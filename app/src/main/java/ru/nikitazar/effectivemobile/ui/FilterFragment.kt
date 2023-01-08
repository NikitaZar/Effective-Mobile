package ru.nikitazar.effectivemobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.nikitazar.effectivemobile.databinding.FragmentFilterBinding

class FilterFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFilterBinding.inflate(inflater, container, false)



        binding.btClose.setOnClickListener {
            dismiss()
        }

        binding.btDone.setOnClickListener {
            //TODO
        }

        return binding.root
    }
}