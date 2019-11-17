package kr.wayde.githubsearch.pagingnation

import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.domain.interactor.usecases.GetUserReposUseCase

class UserReposPagingNation(val compositeDisposable: CompositeDisposable,
                            val userName: String,
                            val getUserReposrUseCase: GetUserReposUseCase):
        PageKeyedDataSource<Int, Repo>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Repo>
    ) {
        compositeDisposable.add(
            getUserReposrUseCase.get(GetUserReposUseCase.Params(userName, 1, params.requestedLoadSize))
                .subscribe({
                    callback.onResult(it, null, 2)
                }, {
                    callback.onResult(emptyList(), null, null)
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Repo>) {
        compositeDisposable.add(
            getUserReposrUseCase.get(GetUserReposUseCase.Params(userName, params.key, params.requestedLoadSize))
                .subscribe({
                    callback.onResult(it, params.key.plus(1))
                }, {

                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Repo>) {

    }
}