package edu.imsa.andyt.smogsafe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import edu.imsa.andyt.smogsafe.R
import edu.imsa.andyt.smogsafe.database.MyViewModel
import edu.imsa.andyt.smogsafe.models.LocationWrapper
import kotlinx.android.synthetic.main.fragment_location_detail.*


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

    val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var position: Int = 0;
        arguments?.let {
            position = it.getInt("POSITION")
        }

        val l: LocationWrapper = viewModel.myNotes[position]
        cityName?.text = l.data.city.name;
        cityAirQuality?.text = l.data.aqi.toString();
        cityLocation?.text = "(${l.data.city.geo[0]}, ${l.data.city.geo[1]})";
        updateTime?.text = "${l.data.time.s} UTC${l.data.time.tz}";


        val map: Map<TextView, Double> = mapOf(
            Pair(pm25, l.data.iaqi.pm25.v),
            Pair(pm10, l.data.iaqi.pm10.v),
            Pair(o3, l.data.iaqi.o3.v),
            Pair(no2, l.data.iaqi.no2.v),
            Pair(so2, l.data.iaqi.so2.v),
            Pair(pm, l.data.iaqi.p.v),
            Pair(co, l.data.iaqi.co.v),
            Pair(hc, l.data.iaqi.h.v),
            Pair(w, l.data.iaqi.w.v)
        )
        for (i in map) {
            if (i.value == -1.0) {
                i.key.text = "N/A"
            } else {
                i.key.text = i.value.toString()
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }
}
