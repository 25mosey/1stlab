package com.example.a1stlab.models

import com.google.gson.annotations.SerializedName

data class University(
    @SerializedName("state-province")var stateProvince:String?=null,
    @SerializedName("domains")var domains:ArrayList<String> =arrayListOf(),
    @SerializedName("web_pages")var webPages:ArrayList<String> =arrayListOf(),
    @SerializedName("country")var country:String?=null,
    @SerializedName("alpha_two_code")var alphaTwoCode:String?=null,
    @SerializedName("name")var name:String?=null
)