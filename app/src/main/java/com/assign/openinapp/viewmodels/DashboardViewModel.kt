package com.assign.openinapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.assign.openinapp.interfaces.DashboardRepository
import com.assign.openinapp.model.DashboardDetails
import com.assign.openinapp.repository.DashboardRepositoryImpl
import com.assign.openinapp.utils.Resource
import io.reactivex.disposables.CompositeDisposable

class DashboardViewModel() : ViewModel() {

    private val dashboardRepository: DashboardRepository = DashboardRepositoryImpl()

    fun getNewDashboard() : LiveData<Resource<DashboardDetails>> {
        return dashboardRepository.getNewDashboard()
    }

}