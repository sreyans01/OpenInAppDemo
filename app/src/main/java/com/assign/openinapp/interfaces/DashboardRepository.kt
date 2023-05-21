package com.assign.openinapp.interfaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assign.openinapp.model.DashboardDetails
import com.assign.openinapp.utils.Resource
import retrofit2.http.GET

interface DashboardRepository {

    fun getNewDashboard(): LiveData<Resource<DashboardDetails>>
}