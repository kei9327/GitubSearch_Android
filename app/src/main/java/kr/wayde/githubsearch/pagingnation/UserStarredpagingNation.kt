package kr.wayde.githubsearch.pagingnation

import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import kr.wayde.githubsearch.domain.entity.Starred
import kr.wayde.githubsearch.domain.interactor.usecases.GetUserStarredrUseCase

class UserStarredpagingNation(val compositeDisposable: CompositeDisposable,
                            val userName: String,
                            val getUserStarredrUseCase: GetUserStarredrUseCase):
    PageKeyedDataSource<Int, Starred>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Starred>
    ) {
        compositeDisposable.add(
            getUserStarredrUseCase.get(GetUserStarredrUseCase.Params(userName, 1, params.requestedLoadSize))
                .subscribe({
                    callback.onResult(it, null, 2)
                }, {
                    callback.onResult(emptyList(), null, null)
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Starred>) {
        compositeDisposable.add(
            getUserStarredrUseCase.get(GetUserStarredrUseCase.Params(userName, params.key, params.requestedLoadSize))
                .subscribe({
                    callback.onResult(it, params.key.plus(1))
                }, {

                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Starred>) {

    }
}