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
import kr.wayde.githubsearch.paging.PagedResult
import kr.wayde.githubsearch.paging.SearchUserDataSourceFactory
import kr.wayde.githubsearch.ui.BaseViewModel

class UserSearchViewModel(private val searchUsersUseCase: SearchUserUseCase) : BaseViewModel() {
    private val config: PagedList.Config = PagedList.Config.Builder().apply {
        setInitialLoadSizeHint(20)
        setPageSize(20)
        setPrefetchDistance(5)
        setEnablePlaceholders(true)
    }.build()

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
                            SearchUserDataSourceFactory(compositeDisposable, it, searchUsersUseCase)
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