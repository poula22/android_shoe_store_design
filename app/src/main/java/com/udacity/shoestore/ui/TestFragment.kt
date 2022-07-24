package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.FragmentTestBinding

class TestFragment:Fragment() {

    lateinit var testFragmentBinging: FragmentTestBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        testFragmentBinging = FragmentTestBinding.inflate(inflater,container,false)
        return testFragmentBinging.root
    }
}