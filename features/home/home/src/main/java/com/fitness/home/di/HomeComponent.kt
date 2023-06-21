package com.fitness.home.di

import com.fitness.home.viewmodel.HomeViewModel
import com.fitness.navigation.di.FeatureScoped
import dagger.Component


@FeatureScoped
@Component
interface HomeComponent {
    val homeViewModel: HomeViewModel
}