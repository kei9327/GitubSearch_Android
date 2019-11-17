package kr.wayde.githubsearch.ui.profile.repo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kr.wayde.githubsearch.databinding.ItemUserRepositoryBinding
import kr.wayde.githubsearch.domain.entity.Repo

class UserRepositoryAdapter : PagedListAdapter<Repo, UserRepositoryAdapter.UserRepositoryViewHolder>(
    ItemDiffCallBack
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRepositoryViewHolder {
        val binding = ItemUserRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return UserRepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserRepositoryViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.viewModel = UserRepositoryItemViewModel(it)
        }
    }

    inner class UserRepositoryViewHolder(val binding: ItemUserRepositoryBinding): RecyclerView.ViewHolder(binding.root)
}

object ItemDiffCallBack : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem.name == newItem.name
    }
}