package com.mobprodasar.nim6706180044.dataTracker


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

import com.mobprodasar.nim6706180044.R
import com.mobprodasar.nim6706180044.database.DataDatabase
import com.mobprodasar.nim6706180044.databinding.ActivityMainBinding
import com.mobprodasar.nim6706180044.databinding.FragmentDataTrackerBinding

/**
 * A simple [Fragment] subclass.
 */
class DataTrackerFragment : Fragment() {
    lateinit var binding: FragmentDataTrackerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_tracker, container, false)


        val application = requireNotNull(this.activity).application
        val dataSource = DataDatabase.getInstance(application).dataDAO
        val viewModelFactory = DataTrackerViewModelFactory(dataSource, application)

        val dataTrackerViewModel = ViewModelProviders.of(this, viewModelFactory).get(DataTrackerViewModel::class.java)

        binding.btTambah.setOnClickListener {
            it.findNavController().navigate(R.id.action_dataTrackerFragment_to_createData)
        }

        setHasOptionsMenu(true)
        binding.setLifecycleOwner(this)

        binding.dataTrackerViewModel = dataTrackerViewModel

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val application = requireNotNull(this.activity).application
        val dataSource = DataDatabase.getInstance(application).dataDAO

        when(item?.itemId) {
            R.id.delete -> DataTrackerViewModel(dataSource, application).onDelete()
        }

        return super.onOptionsItemSelected(item)
    }
}

