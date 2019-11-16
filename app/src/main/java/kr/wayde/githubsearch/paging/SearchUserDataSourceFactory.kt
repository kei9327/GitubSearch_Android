package kr.wayde.githubsearch.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.domain.interactor.usecases.SearchUserUseCase

class SearchUserDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val query: String,
    private val searchUserUseCase: SearchUserUseCase
) : DataSource.Factory<Int, User>() {
    val sourceLiveData = MutableLiveData<SearchUserDataSource>()

    override fun create(): DataSource<Int, User> {
        val userDataSource = SearchUserDataSource(compositeDisposable, query, searchUserUseCase)
        sourceLiveData.postValue(userDataSource)
        return userDataSource
    }
}
