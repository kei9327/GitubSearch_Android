package kr.wayde.githubsearch.domain.interactor.usecases

import io.reactivex.Single
import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.domain.interactor.SingleUseCase
import kr.wayde.githubsearch.domain.repository.GithubRepository
import kr.wayde.githubsearch.domain.schedulers.SchedulersProvider

class GetUserReposUseCase(
    private val githubRepository: GithubRepository,
    schedulersProvider: SchedulersProvider
) : SingleUseCase<List<Repo>, GetUserReposUseCase.Params>(schedulersProvider) {
    override fun buildUseCaseSingle(params: Params): Single<List<Repo>>
        = githubRepository.getUserRepos(userName = params.userName, page = params.page, perPage = params.perPage)

    data class Params(val userName: String, val page: Int, val perPage: Int)
}
