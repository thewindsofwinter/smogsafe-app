package edu.imsa.andyt.smogsafe.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import edu.imsa.andyt.smogsafe.R
import kotlinx.android.synthetic.main.fragment_app_welcome.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AppWelcomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AppWelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AppWelcomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_appWelcomeFragment_to_locationListFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_welcome, container, false)
    }


    }
