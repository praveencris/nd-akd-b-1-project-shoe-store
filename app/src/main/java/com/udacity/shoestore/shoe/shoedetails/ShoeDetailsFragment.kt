package com.udacity.shoestore.shoe.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailsFragment : Fragment() {
    private var _binding: FragmentShoeDetailsBinding? = null
    private val viewModel: MainViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        binding.apply {
            cancelButton.setOnClickListener {
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
            }
            saveButton.setOnClickListener {
                val pair: Pair<Boolean, String?> = viewModel.isValidInputs()
                if (pair.first) {
                    val shoe = Shoe(
                        viewModel.shoe.name,
                        viewModel.shoe.size,
                        viewModel.shoe.company,
                        viewModel.shoe.description,
                        mutableListOf("")
                    )
                    viewModel.addShoeDetails(shoe)
                    viewModel.resetShoe()
                    findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
                } else {
                    Toast.makeText(context, pair.second, Toast.LENGTH_SHORT).show()
                }
            }
            mainViewModel = viewModel
            setLifecycleOwner(this@ShoeDetailsFragment)
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        // Reset the binding when fragment's view gets destroyed to avoid memory leaks
        _binding = null
    }
}