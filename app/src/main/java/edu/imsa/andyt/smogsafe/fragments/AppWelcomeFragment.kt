package edu.imsa.andyt.smogsafe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.imsa.andyt.smogsafe.R
import kotlinx.android.synthetic.main.fragment_app_welcome.*

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
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_appWelcomeFragment_to_locationListFragment)
        }

        buttonCredits.setOnClickListener {
            findNavController().navigate(R.id.action_appWelcomeFragment_to_creditsFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
