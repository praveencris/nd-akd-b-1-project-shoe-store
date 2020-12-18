package com.udacity.shoestore.shoe

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding


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

        viewModel=activity?.run {
            ViewModelProvider(this).get(ShoeListViewModel::class.java)
        }?: throw Exception("Invalid Activity")
        binding.shoeListViewModel = viewModel
        binding.setLifecycleOwner(this)

        binding.shoeDetailsFAB.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }
        setHasOptionsMenu(true)
        val args = ShoeListFragmentArgs.fromBundle(requireArguments())
        if (args.isDetailsSet) {
            viewModel.addShoeDetails(args.shoeDetails!!)
        }
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        requireView().findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return /*NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                ||*/ super.onOptionsItemSelected(item)
    }


}