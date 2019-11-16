package kr.wayde.githubsearch.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import kr.wayde.githubsearch.databinding.FragmentMainBinding
import kr.wayde.githubsearch.ui.BaseFragment

/**o
 * Created by Wayde.k(Jnaghyok Park) on 2019.11.10
 */
class MainFragment : BaseFragment() {
    private val pageAdapter by lazy { MainPagerAdapter(fragmentManager!!) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        viewPager.adapter = pageAdapter
        tabs.setupWithViewPager(viewPager)
    }

}