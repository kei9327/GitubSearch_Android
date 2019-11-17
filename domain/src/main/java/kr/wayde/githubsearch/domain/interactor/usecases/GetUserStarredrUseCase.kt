package kr.wayde.githubsearch.domain.interactor.usecases

import io.reactivex.Single
import kr.wayde.githubsearch.domain.entity.Starred
import kr.wayde.githubsearch.domain.interactor.SingleUseCase
import kr.wayde.githubsearch.domain.repository.GithubRepository
import kr.wayde.githubsearch.domain.schedulers.SchedulersProvider

class GetUserStarredrUseCase(
    private val githubRepository: GithubRepository,
    schedulersProvider: SchedulersProvider
) : SingleUseCase<List<Starred>, GetUserStarredrUseCase.Params>(schedulersProvider) {
    override fun buildUseCaseSingle(params: Params): Single<List<Starred>>
        = githubRepository.getUserStarred(userName = params.userName, page = params.page, perPage = params.perPage)

    data class Params(val userName: String, val page: Int, val perPage: Int)
}
