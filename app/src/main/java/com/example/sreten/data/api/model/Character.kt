package com.example.sreten.data.api.model


import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "character")
@Parcelize
@JsonClass(generateAdapter = true)
data class Character(
    @Json(name = "actor")
    val actor: String,
    @Json(name = "alive")
    val alive: Boolean,
    @Json(name = "alternate_actors")
    val alternateActors: List<String>,
    @Json(name = "alternate_names")
    val alternateNames: List<String>,
    @Json(name = "ancestry")
    val ancestry: String,
    @Json(name = "dateOfBirth")
    val dateOfBirth: String,
    @Json(name = "eyeColour")
    val eyeColour: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "hairColour")
    val hairColour: String,
    @Json(name = "hogwartsStaff")
    val hogwartsStaff: Boolean,
    @Json(name = "hogwartsStudent")
    val hogwartsStudent: Boolean,
    @Json(name = "house")
    val house: String,
    @Json(name = "image")
    val image: String,
    @PrimaryKey
    @Json(name = "name")
    val name: String,
    @Json(name = "patronus")
    val patronus: String,
    @Json(name = "species")
    val species: String,
    @Json(name = "wand")
    @Embedded
    val wand: Wand,
    @Json(name = "wizard")
    val wizard: Boolean,
    @Json(name = "yearOfBirth")
    val yearOfBirth: String?
) : Parcelable