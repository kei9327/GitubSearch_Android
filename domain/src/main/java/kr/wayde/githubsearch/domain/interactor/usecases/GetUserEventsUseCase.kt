package kr.wayde.githubsearch.domain.interactor.usecases

import io.reactivex.Single
import kr.wayde.githubsearch.domain.entity.UserEvent
import kr.wayde.githubsearch.domain.interactor.SingleUseCase
import kr.wayde.githubsearch.domain.repository.GithubRepository
import kr.wayde.githubsearch.domain.schedulers.SchedulersProvider

class GetUserEventsUseCase(
    private val githubRepository: GithubRepository,
    schedulersProvider: SchedulersProvider
) : SingleUseCase<List<UserEvent>, String>(schedulersProvider) {
    override fun buildUseCaseSingle(userName: String): Single<List<UserEvent>>
        = githubRepository.getUserEvents(userName)

}
