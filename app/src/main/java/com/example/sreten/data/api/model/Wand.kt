package com.example.sreten.data.api.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "wand")
@Parcelize
@JsonClass(generateAdapter = true)
data class Wand(
    @PrimaryKey
    @Json(name = "core")
    val core: String,
    @Json(name = "length")
    val length: String?,
    @Json(name = "wood")
    val wood: String
): Parcelable