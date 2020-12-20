package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoe.ShoeRepository

class MainViewModel : ViewModel() {
    val shoeList: LiveData<List<Shoe>>
        get() = ShoeRepository.shoeList

    val shoeListString = ShoeRepository.shoeListString

    fun addShoeDetails(shoeDetail: Shoe) = ShoeRepository.addShoeDetails(shoeDetail)

    private var _shoe: Shoe = Shoe("", "", "", "", mutableListOf(""))
    val shoe: Shoe
        get() = _shoe

    fun resetShoe() {
        _shoe = Shoe("", "", "", "", mutableListOf(""))
    }

    fun isValidInputs(): Pair<Boolean, String?> {
        if (shoe.name.isEmpty()) {
            return Pair(false, "Enter Shoe Name")
        }
        if (shoe.company.isEmpty()) {
            return Pair(false, "Enter Company Name")
        }
        if (shoe.size.isEmpty()) {
            return Pair(false, "Enter Shoe Size")
        }
        if (shoe.description.isEmpty()) {
            return Pair(false, "Enter Shoe Description")
        }
        return Pair(true, null)
    }

}