package com.saahil.dhikr

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CounterViewModel(private val repository: CounterRepository) : ViewModel() {
    // Using LiveData and caching what allCounters returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allCounters: LiveData<List<Counter>> = repository.allCounter.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(counter: Counter) = viewModelScope.launch {
        repository.insert(counter)
    }
}

class CounterViewModelFactory(private val repository: CounterRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CounterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}