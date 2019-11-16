package kr.wayde.githubsearch.domain.interactor.usecases

import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.domain.interactor.SingleUseCase
import io.reactivex.Single
import kr.wayde.githubsearch.domain.repository.GithubRepository
import kr.wayde.githubsearch.domain.schedulers.SchedulersProvider

class SearchUserUseCase(
    private val githubRepository: GithubRepository,
    schedulersProvider: SchedulersProvider
) : SingleUseCase<List<User>, SearchUserUseCase.Params>(schedulersProvider) {
    override fun buildUseCaseSingle(params: Params): Single<List<User>>
        = githubRepository.searchUsers(query = params.query, page = params.page, perPage = params.perPage)

    data class Params(val query: String, val page: Int, val perPage: Int)
}
