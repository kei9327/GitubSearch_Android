package kr.wayde.githubsearch.ui.profile.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.domain.interactor.usecases.GetUserReposUseCase
import kr.wayde.githubsearch.pagingnation.PagedResult
import kr.wayde.githubsearch.pagingnation.UserReposPagingNationFactory
import kr.wayde.githubsearch.ui.BaseViewModel
import kr.wayde.githubsearch.util.config

class UserRepositoryViewModel(private val getUserReposUseCase: GetUserReposUseCase) :
    BaseViewModel() {
    private val result = MutableLiveData<PagedResult<Repo>>()
    val pagedList: LiveData<PagedList<Repo>> = Transformations.switchMap(result) { it.data }

    fun getUserRepository(userName: String) {
        val sourceFactory =
            UserReposPagingNationFactory(compositeDisposable, userName, getUserReposUseCase)
        val livePagedList = LivePagedListBuilder(sourceFactory, config).build()

        result.postValue(PagedResult(data = livePagedList))
    }

}