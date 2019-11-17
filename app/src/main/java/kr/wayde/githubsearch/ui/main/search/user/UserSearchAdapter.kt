package kr.wayde.githubsearch.ui.main.search.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kr.wayde.githubsearch.databinding.ItemSearchUserBinding
import kr.wayde.githubsearch.domain.entity.User

class UserSearchAdapter(val viewModel: UserSearchViewModel) : PagedListAdapter<User, UserSearchAdapter.SearchResultViewHolder>(
    ItemDiffCallBack
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val binding = ItemSearchUserBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return SearchResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.viewModel = UserSearchItemViewModel(it, viewModel)
        }
    }

    inner class SearchResultViewHolder(val binding: ItemSearchUserBinding): RecyclerView.ViewHolder(binding.root)
}

object ItemDiffCallBack : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }
}