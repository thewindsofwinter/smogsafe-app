package edu.imsa.andyt.smogsafe.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.imsa.andyt.smogsafe.models.UserLocation

class MyViewModel : ViewModel() {

    private val _myNotes: MutableLiveData<MutableList<UserLocation>> = MutableLiveData()
    val myNotes: LiveData<MutableList<UserLocation>> = _myNotes

    init {
        val notes = mutableListOf(
            UserLocation("Chicago",40.0,70.0,30),
            UserLocation("Test", -20.0, 30.0,200)
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