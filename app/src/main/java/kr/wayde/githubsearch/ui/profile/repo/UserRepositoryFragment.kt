package kr.wayde.githubsearch.ui.profile.repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_user_repositories.*
import kr.wayde.githubsearch.databinding.FragmentUserRepositoriesBinding
import kr.wayde.githubsearch.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserRepositoryFragment(var userName: String) : BaseFragment() {
    private val viewModel by viewModel<UserRepositoryViewModel>()
    private val adapter by lazy { UserRepositoryAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserRepositoriesBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvRepos.adapter = adapter

        viewModel.pagedList.observe(this, Observer {
            adapter.submitList(it)
        })
        viewModel.getUserRepository(userName)
    }

}