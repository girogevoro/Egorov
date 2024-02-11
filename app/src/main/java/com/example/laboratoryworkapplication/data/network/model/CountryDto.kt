package com.example.laboratoryworkapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("country")
    val value: String?,
)