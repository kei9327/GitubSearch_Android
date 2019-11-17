package kr.wayde.githubsearch.romote.model

import com.google.gson.annotations.SerializedName

data class UserEventModel (
    @SerializedName("id") val id : Long,
    @SerializedName("type") val type : String,
    @SerializedName("actor") val actor : ActorModel,
    @SerializedName("public") val public : Boolean,
    @SerializedName("created_at") val created_at : String)

data class ActorModel (
    @SerializedName("id") val id : Long,
    @SerializedName("login") val login : String,
    @SerializedName("display_login") val display_login : String,
    @SerializedName("gravatar_id") val gravatar_id : String,
    @SerializedName("url") val url : String,
    @SerializedName("avatar_url") val avatar_url : String)

