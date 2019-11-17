package kr.wayde.githubsearch.ui.profile.feed

import kr.wayde.githubsearch.domain.entity.UserEvent
import kr.wayde.githubsearch.ui.BaseObservableViewModel

class UserFeedItemViewModel(var userEvent: UserEvent) : BaseObservableViewModel() {

    // 다 처리하기 힘들어서 생략
    fun getEventInfo(event: UserEvent): CharSequence {
        val eventInfo: CharSequence
        val eventType = event.type
        when (eventType) {
            "PushEvent" -> eventInfo = "푸시를 했음"
            "IssuesEvent" -> eventInfo = "이슈"
            "IssueCommentEvent" -> eventInfo = "이슈에 주석 달음"
            "CreateEvent" -> eventInfo = "생성함"
            "DeleteEvent" -> eventInfo = "삭제함"
            "WatchEvent" -> eventInfo = "WatchEvent"
            "MemberEvent" -> eventInfo = "MemberEvent"
            "ForkEvent" -> eventInfo = "ForkEvent"
            "GollumEvent" -> eventInfo = "GollumEvent"
            "CommitCommentEvent" -> eventInfo = "CommitCommentEvent"
            "PullRequestReviewCommentEvent" -> eventInfo = "PullRequestReviewCommentEvent"
            "ReleaseEvent" -> eventInfo = "ReleaseEvent"
            "PullRequestEvent" -> eventInfo = "ReleaseEvent"
            "PublicEvent" -> eventInfo = "PublicEvent"
            else -> eventInfo = eventType
        }
        return eventInfo
    }
}