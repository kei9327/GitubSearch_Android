package kr.wayde.githubsearch.ui.profile.starred

import kr.wayde.githubsearch.domain.entity.Starred
import kr.wayde.githubsearch.ui.BaseObservableViewModel

class UserStarredItemViewModel(
    var starred: Starred
): BaseObservableViewModel()