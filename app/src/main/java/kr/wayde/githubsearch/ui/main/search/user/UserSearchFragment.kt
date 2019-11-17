package kr.wayde.githubsearch.ui.main.search.user

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_user_search.*
import kr.wayde.githubsearch.R
import kr.wayde.githubsearch.ui.BaseFragment
import kr.wayde.githubsearch.databinding.FragmentUserSearchBinding
import kr.wayde.githubsearch.ui.profile.ProfileActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserSearchFragment : BaseFragment() {
    private lateinit var searchView: SearchView
    private val viewModel by viewModel<UserSearchViewModel>()
    private val adapter by lazy {
        UserSearchAdapter(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserSearchBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        initialize()
    }

    private fun initialize() {
        initializeViews()

        initializeViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_layout, menu)

        val item = menu?.findItem(R.id.search)
        searchView = item?.getActionView() as SearchView
        searchView.setOnQueryTextListener(ActionListener())
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun initializeViews() {
        rvSearchResults.adapter = adapter
    }

    private fun initializeViewModel() {

        viewModel.pagedList.observe(this, Observer {
            adapter.submitList(it)
        })

        viewModel.profileLogin.observe(this, Observer {
            startActivity(ProfileActivity.getStartIntent(context!!, it))
        })
    }

    inner class ActionListener : SearchView.OnQueryTextListener {
        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            viewModel.onClickSearchUser(query)
            return true
        }
    }
}