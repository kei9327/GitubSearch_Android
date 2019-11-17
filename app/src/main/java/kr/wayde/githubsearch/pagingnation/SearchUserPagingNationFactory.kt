package kr.wayde.githubsearch.pagingnation

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.domain.interactor.usecases.SearchUserUseCase

class SearchUserPagingNationFactory(
    private val compositeDisposable: CompositeDisposable,
    private val query: String,
    private val searchUserUseCase: SearchUserUseCase
) : DataSource.Factory<Int, User>() {
    val sourceLiveData = MutableLiveData<SearchUserPagingNation>()

    override fun create(): DataSource<Int, User> {
        val userDataSource = SearchUserPagingNation(compositeDisposable, query, searchUserUseCase)
        sourceLiveData.postValue(userDataSource)
        return userDataSource
    }
}
