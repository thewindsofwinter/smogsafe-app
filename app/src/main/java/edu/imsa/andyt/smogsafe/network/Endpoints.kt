package edu.imsa.andyt.smogsafe.network

import edu.imsa.andyt.smogsafe.models.LocationWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 07 This is where the magic happens.
 *
 * This class is where we define our API endpoints.  We mark each function
 * with an @ notation to specify the type of request we want to perform.
 * We also pass in the second part of the API's URL.
 *
 * When we compile our app, RetroFit writes code for us that handles, switching
 * to a background thread to make sure the UI does not freeze during the request,
 * calling the endpoint, waiting for a response, and parsing the response into
 * Kotlin Objects.
 *
 * @author Marshall Ladd
 */
interface Endpoints {

    @GET("feed/{cityName}/?token=demo")
    fun getCityDataByName(@Path("cityName") cityName: String): Call<LocationWrapper>

}