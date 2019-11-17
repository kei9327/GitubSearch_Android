package kr.wayde.githubsearch.domain.entity

data class UserEvent(
    val id : Long,
    val type : String,
    val actor : Actor,
    val public : Boolean,
    val created_at : String)

data class Actor (
    val id : Long,
    val login : String,
    val display_login : String,
    val gravatar_id : String,
    val url : String,
    val avatar_url : String)
