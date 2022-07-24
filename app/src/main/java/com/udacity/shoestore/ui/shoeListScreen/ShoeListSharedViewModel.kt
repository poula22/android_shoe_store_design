package com.udacity.shoestore.ui.shoeListScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListSharedViewModel:ViewModel() {
    private val _shoeListLiveData= MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeListLiveData:LiveData<MutableList<Shoe>>
    get() = _shoeListLiveData

    fun addShoe(newShoe:Shoe){
        _shoeListLiveData.value?.add(newShoe)
    }
}