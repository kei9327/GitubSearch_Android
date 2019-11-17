package kr.wayde.githubsearch.domain.entity

data class Starred(
    val name : String,
    val full_name : String,
    val description : String,
    val fork : Boolean,
    val language : String,
    val size : Int,
    val stargazers_count : Int,
    val forks_count : Int,
    val updated_at : String
)