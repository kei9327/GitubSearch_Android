package kr.wayde.githubsearch.pagingnation

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.domain.interactor.usecases.GetUserReposUseCase

class UserReposPagingNationFactory(
    private val compositeDisposable: CompositeDisposable,
    private val query: String,
    private val getUserReposrUseCase: GetUserReposUseCase
) : DataSource.Factory<Int, Repo>() {
    val sourceLiveData = MutableLiveData<UserReposPagingNation>()

    override fun create(): DataSource<Int, Repo> {
        val userDataSource = UserReposPagingNation(compositeDisposable, query, getUserReposrUseCase)
        sourceLiveData.postValue(userDataSource)
        return userDataSource
    }
}
