package kr.wayde.githubsearch.data.repository

import kr.wayde.githubsearch.domain.entity.User
import io.reactivex.Single
import kr.wayde.githubsearch.domain.entity.Repo

interface GithubRemote{
    fun searchUsers(query: String, page: Int, perPage: Int): Single<List<User>>
    fun getUserInfo(userName: String): Single<User>
    fun getUserRepos(userName: String): Single<List<Repo>>
}
