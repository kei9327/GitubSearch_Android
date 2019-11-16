package kr.wayde.githubsearch.paging

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

open class PagedResult<T>(var data: LiveData<PagedList<T>>)