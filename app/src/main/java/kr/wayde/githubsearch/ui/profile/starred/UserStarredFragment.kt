package kr.wayde.githubsearch.ui.profile.starred

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_user_starred.*
import kr.wayde.githubsearch.databinding.FragmentUserStarredBinding
import kr.wayde.githubsearch.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserStarredFragment(var userName: String): BaseFragment() {
    private val viewModel by viewModel<UserStarredViewModel>()
    private val adapter by lazy { UserStarredAdpater() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserStarredBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvStarred.adapter = adapter

        viewModel.pagedList.observe(this, Observer {
            adapter.submitList(it)
        })
        viewModel.getUserStarred(userName)
    }
}