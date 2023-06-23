package com.fitness.home.di

import com.fitness.home.viewmodel.HomeViewModel
import dagger.Component


@Component
interface HomeComponent {
    val homeViewModel: HomeViewModel
}