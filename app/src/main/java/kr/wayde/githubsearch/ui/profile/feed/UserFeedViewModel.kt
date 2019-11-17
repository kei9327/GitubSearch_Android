package kr.wayde.githubsearch.ui.profile.feed

import androidx.lifecycle.MutableLiveData
import kr.wayde.githubsearch.domain.entity.UserEvent
import kr.wayde.githubsearch.domain.interactor.usecases.GetUserEventsUseCase
import kr.wayde.githubsearch.ui.BaseViewModel

class UserFeedViewModel(private val getUserEventsUseCase: GetUserEventsUseCase) : BaseViewModel() {
    val result = MutableLiveData<List<UserEvent>>()

    fun getUserFeeds(userName: String) {
        compositeDisposable.add(
            getUserEventsUseCase.get(userName).subscribe { it: List<UserEvent> ->
                result.postValue(it)
            }
        )
    }

}