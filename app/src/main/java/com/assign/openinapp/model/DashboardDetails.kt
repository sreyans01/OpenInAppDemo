package com.assign.openinapp.model

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.io.Serializable

data class DashboardDetails(
    val status: Boolean?,
    val statusCode: Long?,
    val message: String?,
    @SerializedName("support_whatsapp_number") val supportWhatsappNumber: String?,
    @SerializedName("extra_income") val extraIncome: String?,
    @SerializedName("total_links") val total_links: Long?,
    @SerializedName("total_clicks") val total_clicks: Long?,
    @SerializedName("today_clicks") val today_clicks: Long?,
    @SerializedName("top_source") val top_source: String?,
    @SerializedName("top_location") val top_location: String?,
    @SerializedName("startTime") val startTime: String?,
    @SerializedName("links_created_today") val linksCreatedToday: Long?,
    @SerializedName("applied_campaign") val appliedCampaign: Long?,
    @SerializedName("data") val data: Any?,
    @SerializedName("overall_url_chart") val overallUrlChart: Any?,
) : Serializable {

    fun getRecentLinks() : ArrayList<LinkDetails> {
        val map = data as Map<String, Any>
        val recentLinks = map.get("recent_links") as ArrayList<Any>
        val links = ArrayList<LinkDetails>()
        for (link in recentLinks) {
            val jsonObject: JsonObject = Gson().toJsonTree(link).getAsJsonObject()
            val linkDetails = Gson().fromJson(jsonObject, LinkDetails::class.java)
            links.add(linkDetails)
        }
        return links
    }
}