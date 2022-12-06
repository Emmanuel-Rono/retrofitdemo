package com.example.retrofitdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel:ViewModel()
{


     //The viewmodel is used to make the real / actuall call for the data
     private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }
    fun getMarsPhotos()
    {
        viewModelScope.launch {
            try {

                val   thePhotos= api.getPhoto()
                _status.value= "Success: $thePhotos Mars photos retrieved"
            }
            catch (e :Exception)
            {
                _status.value="Failed: ${e.message}"
            }
        }

    }
}