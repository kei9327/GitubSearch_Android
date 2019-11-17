package kr.wayde.githubsearch.ui.empty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.wayde.githubsearch.databinding.FragmentEmptyBinding
import kr.wayde.githubsearch.ui.BaseFragment

class EmptyFragment: BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEmptyBinding.inflate(inflater, container, false)
        return binding.root
    }
}