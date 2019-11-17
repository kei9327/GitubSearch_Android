package kr.wayde.githubsearch.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.wayde.githubsearch.ui.profile.feed.UserFeedFragment

class ProfilePagerAdapter(val userName:String, fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0->Fragment()
            1-> UserFeedFragment(userName)
            else-> Fragment()
        }
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "OVERVIEW"
            1 -> "FEED"
            2 -> "REPOSITORIES"
            3 -> "STARRED (0)"
            4 -> "GIST"
            else -> ""
        }
    }

}