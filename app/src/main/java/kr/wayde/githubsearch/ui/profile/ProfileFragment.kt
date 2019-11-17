package kr.wayde.githubsearch.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import kr.wayde.githubsearch.databinding.FragmentProfileBinding
import kr.wayde.githubsearch.ui.BaseFragment

class ProfileFragment : BaseFragment() {
    private lateinit var userName: String
    private val pageAdapter by lazy { ProfilePagerAdapter(userName, fragmentManager!!) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        activity?.intent?.let { userName = it.getStringExtra("login") }

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