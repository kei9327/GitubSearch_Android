package kr.wayde.githubsearch.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import kr.wayde.githubsearch.R
import kr.wayde.githubsearch.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Wayde.k(Jnaghyok Park) on 2019.11.10
 */
class MainActivity : BaseActivity() {
    lateinit var searchView: SearchView
    private val mainViewModel by viewModel<MainViewModel>()
//    private val userSearchViewModel by viewModel<UserSearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
