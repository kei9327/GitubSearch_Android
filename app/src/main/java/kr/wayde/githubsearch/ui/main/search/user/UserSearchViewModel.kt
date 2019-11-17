package kr.wayde.githubsearch.ui.main.search.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.domain.interactor.usecases.SearchUserUseCase
import kr.wayde.githubsearch.pagingnation.PagedResult
import kr.wayde.githubsearch.pagingnation.SearchUserPagingNationFactory
import kr.wayde.githubsearch.ui.BaseViewModel
import kr.wayde.githubsearch.util.config

class UserSearchViewModel(private val searchUsersUseCase: SearchUserUseCase) : BaseViewModel() {
    private val result = MutableLiveData<PagedResult<User>>()
    val pagedList : LiveData<PagedList<User>> = Transformations.switchMap(result){it.data}
    val profileLogin = MutableLiveData<String>()

    fun onClickSearchUser(query: String?) {
        query
            ?.takeIf { it.isNotEmpty() }
            ?.let {
                launch {
                    val temp = withContext(coroutineContext) {
                        val sourceFactory =
                            SearchUserPagingNationFactory(compositeDisposable, it, searchUsersUseCase)
                        val livePagedList = LivePagedListBuilder(sourceFactory, config).build()
                        return@withContext PagedResult(data = livePagedList)
                    }

                    result.postValue(temp)
                }
            }

    }

    fun onClickUser(userName: String) {
        profileLogin.postValue(userName)
    }


}