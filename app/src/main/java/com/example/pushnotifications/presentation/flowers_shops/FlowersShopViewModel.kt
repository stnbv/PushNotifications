package com.example.pushnotifications.presentation.flowers_shops

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pushnotifications.domain.interactors.FlowersInteractor
import com.example.pushnotifications.domain.models.FlowerShopModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FlowersShopViewModel(flowersInteractor: FlowersInteractor) : ViewModel() {

    val flowersShopsData = MutableLiveData<List<FlowerShopModel>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            flowersShopsData.postValue(flowersInteractor.getFlowerShopsData())
        }
    }
}
