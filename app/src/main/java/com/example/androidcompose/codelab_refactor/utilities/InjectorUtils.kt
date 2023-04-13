package com.example.androidcompose.codelab_refactor.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.androidcompose.codelab_refactor.data.AppDatabase
import com.example.androidcompose.codelab_refactor.data.GardenPlantingRepository
import com.example.androidcompose.codelab_refactor.data.PlantRepository
import com.example.androidcompose.codelab_refactor.viewmodels.GardenPlantingListViewModelFactory
import com.example.androidcompose.codelab_refactor.viewmodels.PlantDetailViewModelFactory
import com.example.androidcompose.codelab_refactor.viewmodels.PlantListViewModelFactory

object InjectorUtils {

    private fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).plantDao()
        )
    }

    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).gardenPlantingDao()
        )
    }

    fun provideGardenPlantingListViewModelFactory(
        context: Context
    ): GardenPlantingListViewModelFactory {
        return GardenPlantingListViewModelFactory(getGardenPlantingRepository(context))
    }

    fun providePlantListViewModelFactory(fragment: Fragment): PlantListViewModelFactory {
        return PlantListViewModelFactory(getPlantRepository(fragment.requireContext()), fragment)
    }

    fun providePlantDetailViewModelFactory(
        context: Context,
        plantId: String
    ): PlantDetailViewModelFactory {
        return PlantDetailViewModelFactory(
            getPlantRepository(context),
            getGardenPlantingRepository(context),
            plantId
        )
    }
}