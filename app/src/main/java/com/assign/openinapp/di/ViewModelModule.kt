package com.assign.openinapp.di

import androidx.lifecycle.ViewModel
import com.assign.openinapp.interfaces.DashboardRepository
import com.assign.openinapp.viewmodels.DashboardViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
class ViewModelModule {

    @Target(AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER)
    @Retention(
        RetentionPolicy.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Provides
    fun viewModelFactory(providerMap: Map<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory {
        return ViewModelFactory(providerMap)
    }


    @Provides
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    fun dashboardViewModel(): ViewModel {
        return DashboardViewModel()
    }
}