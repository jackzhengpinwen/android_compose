package com.example.androidcompose.codelab_refactor.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcompose.codelab_refactor.data.GardenPlantingRepository

class GardenPlantingListViewModelFactory(
    private val repository: GardenPlantingRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }
}
