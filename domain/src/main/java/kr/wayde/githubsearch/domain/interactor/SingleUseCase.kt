package kr.wayde.githubsearch.domain.interactor

import io.reactivex.Single
import kr.wayde.githubsearch.domain.schedulers.SchedulersProvider

abstract class SingleUseCase<T, in Params>(
    private val schedulersProvider: SchedulersProvider
) {
    protected abstract fun buildUseCaseSingle(params: Params): Single<T>

    fun get(params: Params) = buildUseCaseSingle(params)
        .subscribeOn(schedulersProvider.io())
        .observeOn(schedulersProvider.ui())
}
