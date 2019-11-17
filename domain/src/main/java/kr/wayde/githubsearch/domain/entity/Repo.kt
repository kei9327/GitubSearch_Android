package kr.wayde.githubsearch.domain.entity


data class Repo(
    val name: String,
    val full_name: String,
    val description: String,
    val fork: Boolean,
    val size: Int,
    val language: String,
    val stargazers_count: Int,
    val forks_count: Int,
    val updated_at: String
)
