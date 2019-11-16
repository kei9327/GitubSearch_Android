package kr.wayde.githubsearch.romote

import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.romote.mapper.RepoEntityMapper
import kr.wayde.githubsearch.romote.mapper.UserEntityMapper
import io.reactivex.Single
import kr.wayde.githubsearch.data.repository.GithubRemote
import kr.wayde.githubsearch.domain.entity.Repo

class GithubRemoteImpl(
    private val githubAppService: GithubService,
    private val userEntityMapper: UserEntityMapper,
    private val repoEntityMapper: RepoEntityMapper
) : GithubRemote {
    override fun searchUsers(query: String, page: Int, perPage: Int): Single<List<User>> =
        githubAppService.searchUsers(query, page, perPage)
            .map { it.items }
            .map { it.map(userEntityMapper::mapFromRemote) }

    override fun getUserInfo(userName: String): Single<User> = githubAppService
        .getUserInfo(userName)
        .map { userEntityMapper.mapFromRemote(it) }

    override fun getUserRepos(userName: String): Single<List<Repo>> = githubAppService
        .getUserRepos(userName)
        .map { it.map { repoEntityMapper.mapFromRemote(it) } }

}
