package com.example.tinkofflab2023.data.remote.response.constants.items


import com.google.gson.annotations.SerializedName

data class ItemResponse(
//    @SerializedName("attrib")
//    val attrib: List<Any>,
    @SerializedName("cd")
    val cd: Int,
    @SerializedName("charges")
    val charges: Boolean,
//    @SerializedName("components")
//    val components: Any,
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("created")
    val created: Boolean,
    @SerializedName("dname")
    val dname: String,
    @SerializedName("hint")
    val hint: List<String>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("lore")
    val lore: String,
    @SerializedName("mc")
    val mc: Boolean,
    @SerializedName("notes")
    val notes: String,
    @SerializedName("qual")
    val qual: String
)
