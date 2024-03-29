package kr.wayde.githubsearch.romote

import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.romote.mapper.RepoEntityMapper
import kr.wayde.githubsearch.romote.mapper.UserEntityMapper
import io.reactivex.Single
import kr.wayde.githubsearch.data.repository.GithubRemote
import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.domain.entity.Starred
import kr.wayde.githubsearch.domain.entity.UserEvent
import kr.wayde.githubsearch.romote.mapper.StarredEntityMapper
import kr.wayde.githubsearch.romote.mapper.UserEvnetEntityMapper

class GithubRemoteImpl(
    private val githubAppService: GithubService,
    private val userEntityMapper: UserEntityMapper,
    private val repoEntityMapper: RepoEntityMapper,
    private val starredEntityMapper: StarredEntityMapper,
    private val userEventEntityMapper: UserEvnetEntityMapper
) : GithubRemote {
    override fun getUserStarred(userName: String, page: Int, perPage: Int): Single<List<Starred>> =
        githubAppService
            .getUserStarred(userName, page, perPage)
            .map { it.map { starredEntityMapper.mapFromRemote(it) } }

    override fun getUserEvents(userName: String): Single<List<UserEvent>> =
        githubAppService.getUserEvents(userName)
            .map { it.map { userEventEntityMapper.mapFromRemote(it) } }

    override fun searchUsers(query: String, page: Int, perPage: Int): Single<List<User>> =
        githubAppService.searchUsers(query, page, perPage)
            .map { it.items }
            .map { it.map(userEntityMapper::mapFromRemote) }

    override fun getUserInfo(userName: String): Single<User> = githubAppService
        .getUserInfo(userName)
        .map { userEntityMapper.mapFromRemote(it) }

    override fun getUserRepos(userName: String, page: Int, perPage: Int): Single<List<Repo>> =
        githubAppService
            .getUserRepos(userName, page, perPage)
            .map { it.map { repoEntityMapper.mapFromRemote(it) } }
}
