package com.example.pushnotifications.presentation.flowers_info.dialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pushnotifications.domain.interactors.FlowersInteractor
import com.example.pushnotifications.domain.models.FlowerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FlowersInfoDialogViewModel(
    private val flowersInteractor: FlowersInteractor,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val navArgs = FlowersInfoDialogFragmentArgs.fromSavedStateHandle(savedStateHandle)

    val flowerData = MutableLiveData<FlowerModel?>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val data = flowersInteractor.getFlowerData()
            flowerData.postValue(data?.flowers?.find { it.id == navArgs.id })
        }
    }
}
