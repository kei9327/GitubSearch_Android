package kr.wayde.githubsearch.pagingnation

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import kr.wayde.githubsearch.domain.entity.Starred
import kr.wayde.githubsearch.domain.interactor.usecases.GetUserStarredrUseCase

class UserStarredPagingNationFactory(
    private val compositeDisposable: CompositeDisposable,
    private val query: String,
    private val getUserStarredrUseCase: GetUserStarredrUseCase
) : DataSource.Factory<Int, Starred>() {
    val sourceLiveData = MutableLiveData<UserStarredpagingNation>()

    override fun create(): DataSource<Int, Starred> {
        val userDataSource = UserStarredpagingNation(compositeDisposable, query, getUserStarredrUseCase)
        sourceLiveData.postValue(userDataSource)
        return userDataSource
    }
}
