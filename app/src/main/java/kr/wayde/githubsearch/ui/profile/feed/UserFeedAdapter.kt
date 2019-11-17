package kr.wayde.githubsearch.ui.profile.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.wayde.githubsearch.databinding.ItemUserFeedBinding
import kr.wayde.githubsearch.domain.entity.UserEvent


class UserFeedAdapter(val context: Context,  public var userEventList: List<UserEvent> = arrayListOf()):
    RecyclerView.Adapter<UserFeedAdapter.UserFeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserFeedViewHolder {
        val binding = ItemUserFeedBinding.inflate(LayoutInflater.from(context), parent, false)
        return UserFeedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userEventList.size
    }

    override fun onBindViewHolder(holder: UserFeedViewHolder, position: Int) {
        userEventList[position]?.let {
            holder.binding.viewModel = UserFeedItemViewModel(it)
        }
    }

    inner class UserFeedViewHolder(val binding: ItemUserFeedBinding): RecyclerView.ViewHolder(binding.root)
}