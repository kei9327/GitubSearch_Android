package kr.wayde.githubsearch.ui.profile.starred

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kr.wayde.githubsearch.databinding.ItemUserStarredBinding
import kr.wayde.githubsearch.domain.entity.Starred

class UserStarredAdpater: PagedListAdapter<Starred, UserStarredAdpater.UserStarredViewHolder> (ItemDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserStarredViewHolder {
        val binding = ItemUserStarredBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return UserStarredViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserStarredViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.viewModel = UserStarredItemViewModel(it)
        }
    }

    inner class UserStarredViewHolder(val binding:ItemUserStarredBinding): RecyclerView.ViewHolder(binding.root)
}

object ItemDiffCallBack : DiffUtil.ItemCallback<Starred>() {
    override fun areItemsTheSame(oldItem: Starred, newItem: Starred): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Starred, newItem: Starred): Boolean {
        return oldItem.name == newItem.name
    }
}
