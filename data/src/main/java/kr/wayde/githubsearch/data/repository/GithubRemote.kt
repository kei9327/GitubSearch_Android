package kr.wayde.githubsearch.data.repository

import kr.wayde.githubsearch.domain.entity.User
import io.reactivex.Single
import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.domain.entity.UserEvent

interface GithubRemote{
    fun searchUsers(query: String, page: Int, perPage: Int): Single<List<User>>
    fun getUserInfo(userName: String): Single<User>
    fun getUserRepos(userName: String): Single<List<Repo>>
    fun getUserEvents(userName: String): Single<List<UserEvent>>
}
