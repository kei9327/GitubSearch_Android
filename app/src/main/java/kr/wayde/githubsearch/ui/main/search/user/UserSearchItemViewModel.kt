package kr.wayde.githubsearch.ui.main.search.user

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.facebook.drawee.view.SimpleDraweeView
import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.ui.BaseObservableViewModel

class UserSearchItemViewModel(
    var user: User,
    val viewModel: UserSearchViewModel
): BaseObservableViewModel() {

    companion object {
        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun loadImage(view: SimpleDraweeView, imageUrl: String) {
            view.setImageURI(imageUrl)
        }
    }

    fun onClickUser(userName: String) {
        viewModel.onClickUser(userName)
    }
}