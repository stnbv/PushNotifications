package com.example.pushnotifications.presentation.flowers_info.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pushnotifications.domain.interactors.FlowersInteractor
import com.example.pushnotifications.domain.models.FlowersDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FlowersInfoViewModel(
    private val flowersInteractor: FlowersInteractor
) : ViewModel() {

    val flowerData = MutableLiveData<FlowersDataModel>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
           flowerData.postValue(flowersInteractor.getFlowerData())
        }
    }
}
