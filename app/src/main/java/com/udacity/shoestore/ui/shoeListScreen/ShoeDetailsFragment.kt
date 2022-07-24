package com.udacity.shoestore.ui.shoeListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment:Fragment() {
    lateinit var shoeDetailsFragmentBinding:FragmentShoeDetailsBinding
    lateinit var shoeListViewModel:ShoeListSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shoeListViewModel=ViewModelProvider(requireActivity()).get(ShoeListSharedViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoeDetailsFragmentBinding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        return shoeDetailsFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoeDetailsFragmentBinding.cancelBtn.setOnClickListener { view->
            view.findNavController().popBackStack()
        }

        shoeDetailsFragmentBinding.saveBtn.setOnClickListener { view->

            if (validate()){
                addShoe()
                view.findNavController().popBackStack()
            }else{
                Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun addShoe() {
        val newShoe=Shoe(
            shoeDetailsFragmentBinding.shoeNameText.text.toString(),
            shoeDetailsFragmentBinding.sizeText.text.toString().toDouble(),
            shoeDetailsFragmentBinding.companyText.text.toString(),
            shoeDetailsFragmentBinding.descriptionText.text.toString()
        )
        shoeListViewModel.addShoe(newShoe)
        Toast.makeText(requireContext(), "shoe added completely", Toast.LENGTH_SHORT).show()
    }

    private fun validate(): Boolean {
        var flag=true
        if(shoeDetailsFragmentBinding.shoeNameText.text.isNullOrEmpty()){
            shoeDetailsFragmentBinding.shoeNameText.error="enter shoe name"
            flag=false
        }
        if(shoeDetailsFragmentBinding.sizeText.text.isNullOrEmpty()){
            shoeDetailsFragmentBinding.sizeText.error="enter shoe size"
            flag=false
        }
        if(shoeDetailsFragmentBinding.companyText.text.isNullOrEmpty()){
            shoeDetailsFragmentBinding.companyText.error="enter shoe company"
            flag=false
        }
        if(shoeDetailsFragmentBinding.descriptionText.text.isNullOrEmpty()){
            shoeDetailsFragmentBinding.descriptionText.error="enter shoe description"
            flag=false
        }
        return flag
    }
}