package edu.imsa.andyt.smogsafe.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.imsa.andyt.smogsafe.models.*

class MyViewModel : ViewModel() {

    private val _myNotes: MutableLiveData<MutableList<LocationWrapper>> = MutableLiveData()
    val myNotes: LiveData<MutableList<LocationWrapper>> = _myNotes

    init {
        val notes = mutableListOf(
            LocationWrapper(
                Data(
                    70, listOf(), City(listOf(41.913600, -87.723900), "Shanghai", "https://aqicn.org/city/shanghai"),
                    Debug("2019-08-08T03:58:57+09:00"), "pm25", Iaqi(), 1437, Time("", "", 1)
                ), "ok"
            )
        )
        _myNotes.postValue(notes)
    }

    /* fun addNote() {
        val list = _myNotes.value
        list?.add(Note(noteTitles.random(), noteContent.random(), arrayOf(true, false).random()))
        _myNotes.postValue(list)
    }

    fun deleteNote(note: Note) {
        val list = _myNotes.value
        list?.remove(note)
        _myNotes.postValue(list)
    } */
}