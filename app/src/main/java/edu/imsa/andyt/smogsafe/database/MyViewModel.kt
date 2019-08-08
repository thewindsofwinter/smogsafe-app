package edu.imsa.andyt.smogsafe.database

import android.util.Log
import androidx.lifecycle.ViewModel
import edu.imsa.andyt.smogsafe.models.*

class MyViewModel : ViewModel() {

    var myNotes: MutableList<LocationWrapper> = mutableListOf()

    init {
        val notes = mutableListOf(
            LocationWrapper(
                Data(
                    70, listOf(), City(listOf(41.913600, -87.723900), "shanghai", "https://aqicn.org/city/shanghai"),
                    Debug("2019-08-08T03:58:57+09:00"), "pm25", Iaqi(), 1437, Time("", "", 1)
                ), "ok"
            ),
            LocationWrapper(
                Data(
                    70, listOf(), City(listOf(41.913600, -87.723900), "beijing", "https://aqicn.org/city/shanghai"),
                    Debug("2019-08-08T03:58:57+09:00"), "pm25", Iaqi(), 1437, Time("", "", 1)
                ), "ok"
            )
        )
        myNotes = notes
    }

    fun amendData(l: LocationWrapper, i: Int) {
        Log.i("amendData", "AMEND_DATA")
        val list = myNotes
        list[i] = l;
        myNotes = list
    }

    /*fun addLocation() {
        val list = _myNotes.value
        list?.add(Note(noteTitles.random(), noteContent.random(), arrayOf(true, false).random()))
        _myNotes.postValue(list)
    }*/

    /*fun deleteNote(note: Note) {
        val list = _myNotes.value
        list?.remove(note)
        _myNotes.postValue(list)
    } */
}