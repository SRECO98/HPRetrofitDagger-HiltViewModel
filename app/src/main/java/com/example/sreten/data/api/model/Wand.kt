package com.example.sreten.data.api.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Wand(
    @Json(name = "core")
    val core: String,
    @Json(name = "length")
    val length: String?,
    @Json(name = "wood")
    val wood: String
): Parcelable