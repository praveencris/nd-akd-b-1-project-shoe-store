package com.udacity.shoestore.shoe.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailsFragment : Fragment() {
    private var _binding: FragmentShoeDetailsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }
        binding.saveButton.setOnClickListener {
            val pair: Pair<Boolean, String?> = isValidInputs(binding)
            if (pair.first) {
                val shoe: Shoe = Shoe(
                    binding.shoeNameEditText.text.toString(),
                    binding.shoeSizeEditText.text.toString().toDouble(),
                    binding.companyNameEditText.text.toString(),
                    binding.descriptionEditText.text.toString(),
                    mutableListOf("")
                )
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment(shoe,true))
            } else {
                Toast.makeText(context, pair.second, Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    private fun isValidInputs(binding: FragmentShoeDetailsBinding): Pair<Boolean, String?> {
        if (binding.shoeNameEditText.text.isEmpty()) {
            return Pair(false, "Enter Shoe Name")
        }
        if (binding.companyNameEditText.text.isEmpty()) {
            return Pair(false, "Enter Company Name")
        }
        if (binding.shoeSizeEditText.text.isEmpty()) {
            return Pair(false, "Enter Shoe Size")
        }
        if (binding.descriptionEditText.text.isEmpty()) {
            return Pair(false, "Enter Shoe Description")
        }
        return Pair(true, null)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Reset the binding when fragment's view gets destroyed to avoid memory leaks
        _binding=null
    }
}