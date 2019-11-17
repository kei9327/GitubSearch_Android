package kr.wayde.githubsearch.data.interactor

import kr.wayde.githubsearch.domain.entity.User
import io.reactivex.Single
import kr.wayde.githubsearch.data.repository.GithubRemote
import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.domain.entity.Starred
import kr.wayde.githubsearch.domain.entity.UserEvent
import kr.wayde.githubsearch.domain.repository.GithubRepository

class GithubDataSource(
    private val remote: GithubRemote
) : GithubRepository {
    override fun getUserStarred(userName: String, page: Int, perPage: Int): Single<List<Starred>>
            = remote.getUserStarred(userName, page, perPage)

    override fun getUserEvents(userName: String): Single<List<UserEvent>>
            = remote.getUserEvents(userName)

    override fun searchUsers(query: String, page: Int, perPage: Int): Single<List<User>>
            = remote.searchUsers(query, page, perPage)

    override fun getUserInfo(userName: String): Single<User>
            = remote.getUserInfo(userName)

    override fun getUserRepos(userName: String, page: Int, perPage: Int): Single<List<Repo>>
            = remote.getUserRepos(userName, page, perPage)
}
