package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLogInBinding

class LogInFragment:Fragment() {
    lateinit var logInFragmentBinding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logInFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_log_in, container, false)
        return logInFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logInFragmentBinding.loginBtn.setOnClickListener { view->
            view.findNavController().navigate(LogInFragmentDirections.actionFragmentLogInToFragmentWelcome())
        }
    }

}