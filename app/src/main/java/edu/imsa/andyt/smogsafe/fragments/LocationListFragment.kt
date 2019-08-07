package edu.imsa.andyt.smogsafe.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import edu.imsa.andyt.smogsafe.R
import edu.imsa.andyt.smogsafe.adapter.LocationRecyclerViewAdapter
import edu.imsa.andyt.smogsafe.database.MyViewModel
import edu.imsa.andyt.smogsafe.models.LocationWrapper
import edu.imsa.andyt.smogsafe.network.Endpoints
import edu.imsa.andyt.smogsafe.network.RetroFitInstance
import kotlinx.android.synthetic.main.fragment_location_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    private fun fetchDataFromServer(adapter: LocationRecyclerViewAdapter, model: MyViewModel) {
        // Gets our endpoints as defined in the Endpoints interface
        val apiCalls = RetroFitInstance.retrofit
        // Gets the specific call we want
        val requestList = mutableListOf<Call<LocationWrapper>>()
        for (userLocation in (model.myNotes.value ?: mutableListOf<LocationWrapper>())) {
            val request = apiCalls.create(Endpoints::class.java).getCityDataByName(userLocation.data.city.name)
            requestList.add(request);
        }

        // val request = apiCalls.create(Endpoints::class.java).getCityDataByName()
        /* This line is where the actual request is triggered. It requires a Callback.
        A Callback is a way of telling the app what to do when it gets a response
        back from the API.

        NOTE: Make sure you import the RetroFit2 Callback and that the Callback type
        inside the <> matches what is inside the <> in the declaration of the function
        in the Endpoints interface.
        */
        for (request in requestList) {
            request.enqueue(object : Callback<LocationWrapper> {
                // Tell the app what to do if the network call fails for any reason.
                override fun onFailure(call: Call<LocationWrapper>, t: Throwable) {
                    // Logcat Warn
                    Log.w(javaClass.name, "getEmployeeList() failed. Error: ${t.message}")
                    // Show pop up if Fragment is still in view
                    frameLayout?.let {
                        Snackbar.make(it, "Network request failed.", Snackbar.LENGTH_LONG).show()
                    }
                }

                // Tell the app what to do if the network call responds.  This does not mean that it
                // got your data yet.  A 404 from the API is a response.
                override fun onResponse(call: Call<LocationWrapper>, response: Response<LocationWrapper>) {
                    // Get response code
                    when (response.code()) {
                        // 200 equals a successful GET request that will contain the data requested
                        200 -> {
                            // data requested may have succeeded, but there may have been 0 results,
                            // so we check for null first
                            response.body()?.let {
                                // if not null, send the data to the ListAdapter so that it can be
                                // shown in the RecyclerView
                                model.myNotes.value?.add(it)
                                adapter.submitList(model.myNotes.value)
                            }
                        }
                        // If response code is anything but 200, show an error and the error code
                        else -> {
                            frameLayout?.let {
                                Snackbar.make(
                                    it,
                                    "Something went wrong. CODE: ${response.code()}",
                                    Snackbar.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                }
            })
        }

    }
}