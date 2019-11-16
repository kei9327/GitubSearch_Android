package kr.wayde.githubsearch.paging

import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.domain.interactor.usecases.SearchUserUseCase

class SearchUserDataSource(val compositeDisposable: CompositeDisposable,
                           val query: String,
                           val searchUserUseCase: SearchUserUseCase):
        PageKeyedDataSource<Int, User>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, User>
    ) {
        compositeDisposable.add(
            searchUserUseCase.get(SearchUserUseCase.Params(query, 1, params.requestedLoadSize))
                .subscribe({
                    callback.onResult(it, null, 2)
                }, {
                    callback.onResult(emptyList(), null, null)
                })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        compositeDisposable.add(
            searchUserUseCase.get(SearchUserUseCase.Params(query, params.key, params.requestedLoadSize))
                .subscribe({
                    callback.onResult(it, params.key.plus(1))
                }, {

                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {

    }
}