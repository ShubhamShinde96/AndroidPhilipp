package com.shubham.sharedviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shubham.sharedviewmodel.databinding.Fragment1Binding

class Fragment1 : Fragment(R.layout.fragment_1) {



   /* override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)


    }*/

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

//    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var countryEdtx: EditText
    private lateinit var btnSaveCountry: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryEdtx = view.findViewById(R.id.edtx_country)
        btnSaveCountry = view.findViewById(R.id.button_save)

//        sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // so now because of requireActivity() viewmodel is instantiated on activity so in fragment 2 we'll be referencing
        // to the same view-model so we'll get the same data.

        sharedViewModel.country.observe(viewLifecycleOwner,  { country ->
            countryEdtx.setText(country)
        })

        btnSaveCountry.setOnClickListener {

            sharedViewModel.saveCountry(countryEdtx.text.toString())
            findNavController().navigate(R.id.action_fragment1_to_fragment2)
        }

    }

}