package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment:Fragment() {
    lateinit var welcomeFragmentBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        welcomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        return welcomeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        welcomeFragmentBinding.nextBtn.setOnClickListener { view ->
            view.findNavController().navigate(WelcomeFragmentDirections.actionFragmentWelcomeToInstructionsFragment())

        }
    }
}