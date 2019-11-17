package kr.wayde.githubsearch.domain.repository

import io.reactivex.Single
import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.domain.entity.UserEvent

interface GithubRepository {
    fun searchUsers(query:String, page: Int, perPage: Int): Single<List<User>>
    fun getUserEvents(userName: String): Single<List<UserEvent>>
    fun getUserInfo(userName: String): Single<User>
    fun getUserRepos(userName: String): Single<List<Repo>>
}