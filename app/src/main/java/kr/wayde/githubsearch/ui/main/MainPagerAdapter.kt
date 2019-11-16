package kr.wayde.githubsearch.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.wayde.githubsearch.ui.main.search.user.UserSearchFragment

class MainPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> Fragment()
            1 -> UserSearchFragment()
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Repositories(0)"
            1 -> "Users(0)"
            2 -> "Issues(0)"
            else -> ""
        }
    }
}