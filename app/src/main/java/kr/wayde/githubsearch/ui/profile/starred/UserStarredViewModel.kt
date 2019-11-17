package kr.wayde.githubsearch.ui.profile.starred

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kr.wayde.githubsearch.domain.entity.Starred
import kr.wayde.githubsearch.domain.interactor.usecases.GetUserStarredrUseCase
import kr.wayde.githubsearch.pagingnation.PagedResult
import kr.wayde.githubsearch.pagingnation.UserStarredPagingNationFactory
import kr.wayde.githubsearch.ui.BaseViewModel
import kr.wayde.githubsearch.util.config

class UserStarredViewModel(private val getUserStarredrUseCase: GetUserStarredrUseCase):
        BaseViewModel() {
    private val result = MutableLiveData<PagedResult<Starred>>()
    val pagedList: LiveData<PagedList<Starred>> = Transformations.switchMap(result) { it.data }

    fun getUserStarred(userName: String) {
        val sourceFactory =
            UserStarredPagingNationFactory(compositeDisposable, userName, getUserStarredrUseCase)
        val livePagedList = LivePagedListBuilder(sourceFactory, config).build()

        result.postValue(PagedResult(data = livePagedList))
    }
}