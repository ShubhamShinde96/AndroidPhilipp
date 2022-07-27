package com.shubham.sharedviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.shubham.sharedviewmodel.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    private var _binding: Fragment2Binding? = null
    private val binding get() =  _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_2, container, false)
        _binding = Fragment2Binding.inflate(layoutInflater)

        sharedViewModel.country.observe(viewLifecycleOwner, { country ->
            binding.edtxCountry.setText(country)
        })

        binding.buttonSave.setOnClickListener {

            sharedViewModel.saveCountry(binding.edtxCountry.text.toString())
            findNavController().navigate(R.id.action_fragment2_to_fragment1)
        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}