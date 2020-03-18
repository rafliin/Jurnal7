package com.mobprodasar.nim6706180044.dataCreate


import android.app.Application
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil

import com.mobprodasar.nim6706180044.R
import com.mobprodasar.nim6706180044.database.DataDAO
import com.mobprodasar.nim6706180044.database.DataDatabase
import com.mobprodasar.nim6706180044.database.DataMasukan
import com.mobprodasar.nim6706180044.databinding.FragmentCreateDataBinding
import javax.sql.DataSource

/**
 * A simple [Fragment] subclass.
 */
class CreateData : Fragment() {
    private lateinit var binding:FragmentCreateDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_data, container, false)



        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val dataData = DataMasukan()
        val application = requireNotNull(this.activity).application
        val dataSource = DataDatabase.getInstance(application).dataDAO

        dataData.teks = binding.etData.text.toString()

        when(item?.itemId) {
            R.id.done -> saveData(dataSource,dataData,application)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveData(dataSource: DataDAO, data: DataMasukan, application: Application) {
        CreateDataViewModel(dataSource, data, application).onSave()
        binding.etData.text.clear()
    }


}
