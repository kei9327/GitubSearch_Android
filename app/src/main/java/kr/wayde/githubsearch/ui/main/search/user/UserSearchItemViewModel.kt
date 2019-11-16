package kr.wayde.githubsearch.ui.main.search.user

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView
import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.ui.BaseObservableViewModel

class UserSearchItemViewModel(var user: User): BaseObservableViewModel() {
    companion object {
        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun loadImage(view: SimpleDraweeView, imageUrl: String) {
            view.setImageURI(imageUrl)
        }
    }
}