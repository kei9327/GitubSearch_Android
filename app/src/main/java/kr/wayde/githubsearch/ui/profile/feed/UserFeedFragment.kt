package kr.wayde.githubsearch.ui.profile.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_user_events.*
import kr.wayde.githubsearch.databinding.FragmentUserEventsBinding
import kr.wayde.githubsearch.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserFeedFragment(var userName: String): BaseFragment() {
    private  val viewModel by viewModel<UserFeedViewModel>()
    private val adapter by lazy {
        UserFeedAdapter(context = context!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserEventsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvEvents.adapter = adapter

        viewModel.result.observe(this, Observer {
            adapter.userEventList = it
            adapter.notifyDataSetChanged()
        })
        viewModel.getUserFeeds(userName)
    }
}