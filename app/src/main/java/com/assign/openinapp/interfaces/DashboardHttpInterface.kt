package com.assign.openinapp.interfaces

import com.assign.openinapp.model.DashboardDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DashboardHttpInterface {

    @GET("v1/dashboardNew")
    fun getNewDashboard(): Call<DashboardDetails>
}