package com.fitness.home.viewmodel

import com.fitness.framework.state.BaseViewState
import com.fitness.framework.viewmodel.IntentViewModel
import com.fitness.remote.usecase.user.ReadUserUseCase

import javax.inject.Inject


class HomeViewModel @Inject constructor(
    val readUserUseCase: ReadUserUseCase
) : IntentViewModel<BaseViewState<HomeState>, HomeEvent>() {

    override fun onTriggerEvent(event: HomeEvent) {
        when(event){
            is HomeEvent.LoadHomeData -> onLoadHomeData(event.uid)
        }
    }

    private fun onLoadHomeData(uid: String) = safeLaunch {
        val params = ReadUserUseCase.Params(id = uid)
        call(readUserUseCase(params)){
            setState(BaseViewState.Data(HomeState(it)))
        }
    }
}