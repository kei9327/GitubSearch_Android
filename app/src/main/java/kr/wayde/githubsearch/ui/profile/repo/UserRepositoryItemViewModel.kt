package kr.wayde.githubsearch.ui.profile.repo

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView
import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.ui.BaseObservableViewModel

class UserRepositoryItemViewModel(
    var repo: Repo
): BaseObservableViewModel()