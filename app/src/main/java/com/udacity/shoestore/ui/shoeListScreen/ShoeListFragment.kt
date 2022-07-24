package com.udacity.shoestore.ui.shoeListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment:Fragment() {

    lateinit var  shoeListFragmentDataBinding:FragmentShoeListBinding
    lateinit var shoeListViewModel:ShoeListSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shoeListViewModel= ViewModelProvider(requireActivity()).get(ShoeListSharedViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoeListFragmentDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list,container,false)
        return shoeListFragmentDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
        setHasOptionsMenu(true)
        shoeListFragmentDataBinding.addBtn.setOnClickListener{view->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

    }

    private fun subscribeToLiveData() {
        shoeListViewModel.shoeListLiveData.observe(viewLifecycleOwner){
            it?.forEach {shoe->
                val linearLayout:LinearLayout=shoeListFragmentDataBinding.linearLayout
                val inflater=LayoutInflater.from(requireContext())
                val shoeBinding:ShoeItemBinding=DataBindingUtil.inflate(inflater,R.layout.shoe_item,null,false)
                shoeBinding.item= shoe
                linearLayout.addView(shoeBinding.root)
            }
        }
    }
}