package edu.imsa.andyt.smogsafe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.imsa.andyt.smogsafe.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LocationDetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LocationDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LocationDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_detail, container, false)
    }

}
