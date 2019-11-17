package kr.wayde.githubsearch.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.wayde.githubsearch.ui.empty.EmptyFragment
import kr.wayde.githubsearch.ui.main.search.user.UserSearchFragment

class MainPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            1 -> UserSearchFragment()
            else -> EmptyFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Repositories"
            1 -> "Users"
            2 -> "Issues"
            else -> ""
        }
    }
}