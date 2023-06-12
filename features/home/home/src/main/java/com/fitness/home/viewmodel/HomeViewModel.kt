package com.fitness.home.viewmodel

import com.fitness.framework.state.BaseViewState
import com.fitness.framework.viewmodel.IntentViewModel
import com.fitness.home.HomeEvent
import com.fitness.home.HomeState

import javax.inject.Inject


class HomeViewModel @Inject constructor() : IntentViewModel<BaseViewState<HomeState>, HomeEvent>() {


    override fun onTriggerEvent(event: HomeEvent) {
        when(event){
            is HomeEvent.LoadHomeData -> onLoadHomeData()
        }
    }

    private fun onLoadHomeData() {}
}