package com.udacity.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {
    private lateinit var viewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = viewModel
        binding.setLifecycleOwner(this)

        binding.shoeDetailsFAB.setOnClickListener {
            Timber.i("FAB Clicked!!")
        }

        return binding.root
    }
}