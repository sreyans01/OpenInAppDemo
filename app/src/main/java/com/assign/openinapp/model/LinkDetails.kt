package com.assign.openinapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class LinkDetails(
    @SerializedName("url_id") val urlId: Long,
    @SerializedName("web_link") val webLink: String?,
    @SerializedName("smart_link") val smartLink: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("total_clicks") val totalClicks: Long,
    @SerializedName("original_image") val imageUrl: String?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("times_ago") val timesAgo: String?,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("domain_id") val domainId: String?,
    @SerializedName("url_prefix") val urlPrefix: String?,
    @SerializedName("url_suffix") val urlSuffix: String?,
    @SerializedName("app") val app: String?,
) : Serializable