package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe( var name: String,  var size: String,  var company: String,  var description: String,
                val images: List<String> = mutableListOf()) : Parcelable