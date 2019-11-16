package kr.wayde.githubsearch.romote.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("login") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val profile: String,
    @SerializedName("score") val score: Float
)
