package com.udacity.shoestore.models

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry


data class Shoe(
    var name: String,private var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
)  {
    fun getSize(): String {
        if (size <= 0.0) {
            return ""
        }
        return size.toString()
    }

    fun setSize(newSize: String) {
        if (newSize.isEmpty()) {
            size = 0.0
        } else {
            size = newSize.toDouble()
        }
    }
}