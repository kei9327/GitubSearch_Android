package kr.wayde.githubsearch.romote.model

import com.google.gson.annotations.SerializedName

data class RepoModel(
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val full_name: String,
    @SerializedName("description") val description: String,
    @SerializedName("fork") val fork: Boolean,
    @SerializedName("size") val size: Int,
    @SerializedName("language") val language: String,
    @SerializedName("stargazers_count") val stargazers_count: Int,
    @SerializedName("forks_count") val forks_count: Int,
    @SerializedName("updated_at") val updated_at: String
)
