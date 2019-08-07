package edu.imsa.andyt.smogsafe.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.imsa.andyt.smogsafe.R
import edu.imsa.andyt.smogsafe.adapter.LocationRecyclerViewAdapter
import edu.imsa.andyt.smogsafe.database.MyViewModel

import kotlinx.android.synthetic.main.fragment_location_list.*

class LocationListFragment : Fragment() {

    val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = LocationRecyclerViewAdapter { position ->
            val bundle = bundleOf("POSITION" to position)
            findNavController().navigate(R.id.action_locationListFragment_to_locationDetailFragment, bundle)
        }
        val myLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.apply {
            this.layoutManager = myLayoutManager
            this.adapter = adapter
        }


        viewModel.myNotes.observe(this, Observer {
            it?.let { noteList ->
                Log.d(javaClass.name, "number of notes = ${noteList.size}")
                adapter.submitList(ArrayList(noteList))
            }
        })

    }

}