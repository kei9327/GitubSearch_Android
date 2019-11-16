package kr.wayde.githubsearch.romote.model

import com.google.gson.annotations.SerializedName

data class UsersResultModel(
    @SerializedName("total_count") var total_count: Int = 0,
    @SerializedName("incomplete_results")  var incomplete_results: Boolean = false,
    @SerializedName("items") var items: List<UserModel> = listOf()
)
