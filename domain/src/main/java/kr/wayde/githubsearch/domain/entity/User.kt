package kr.wayde.githubsearch.domain.entity


data class User(
    val name: String,
    val id: Int,
    val profile: String,
    val score: Float
)
