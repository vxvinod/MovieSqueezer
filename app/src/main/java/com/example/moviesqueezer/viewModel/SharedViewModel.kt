package com.example.moviesqueezer.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

class SharedViewModel : ViewModel() {
    val selected = MutableLiveData<String>()

    fun selectedItem(item: String) {
        selected.value = item
    }
}
