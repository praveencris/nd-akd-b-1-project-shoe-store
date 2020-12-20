package com.udacity.shoestore.shoe

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ListItemShoeDeteailsBinding


/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentShoeListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)
            .apply {
                mainViewModel = viewModel
                setLifecycleOwner(this@ShoeListFragment)
            }
        binding.shoeDetailsFAB.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            for (shoe in shoeList) {
                val listItemBinding: ListItemShoeDeteailsBinding = DataBindingUtil.inflate(
                    inflater,
                    R.layout.list_item_shoe_deteails,
                    container,
                    false
                )
                //set binding variable
                listItemBinding.shoe=shoe
                //Add to  LinearLayout inside scrollview
                binding.showListLinearLayout.addView(listItemBinding.root)
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        requireView().findNavController()
            .navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Reset the binding when fragment's view gets destroyed to avoid memory leaks
        _binding = null
    }
}