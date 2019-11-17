package kr.wayde.githubsearch.di

import kr.wayde.githubsearch.BuildConfig
import kr.wayde.githubsearch.data.interactor.GithubDataSource
import kr.wayde.githubsearch.data.repository.GithubRemote
import kr.wayde.githubsearch.domain.interactor.usecases.GetUserEventsUseCase
import kr.wayde.githubsearch.domain.interactor.usecases.SearchUserUseCase
import kr.wayde.githubsearch.domain.repository.GithubRepository
import kr.wayde.githubsearch.domain.schedulers.SchedulersProvider
import kr.wayde.githubsearch.romote.GithubRemoteImpl
import kr.wayde.githubsearch.romote.GithubServiceFactory
import kr.wayde.githubsearch.romote.mapper.RepoEntityMapper
import kr.wayde.githubsearch.romote.mapper.UserEntityMapper
import kr.wayde.githubsearch.romote.mapper.UserEvnetEntityMapper
import kr.wayde.githubsearch.ui.main.MainViewModel
import kr.wayde.githubsearch.ui.main.search.user.UserSearchItemViewModel
import kr.wayde.githubsearch.ui.main.search.user.UserSearchViewModel
import kr.wayde.githubsearch.ui.profile.feed.UserFeedItemViewModel
import kr.wayde.githubsearch.ui.profile.feed.UserFeedViewModel
import kr.wayde.githubsearch.util.AppSchedulerProvider
import kr.wayde.githubsearch.util.Logger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    single { Logger() }
    single { AppSchedulerProvider() as SchedulersProvider }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { UserSearchViewModel(get()) }
    viewModel { UserSearchItemViewModel(get(), get()) }
    viewModel { UserFeedViewModel(get()) }
    viewModel { UserFeedItemViewModel(get()) }
}

val domainModule = module {
    single { SearchUserUseCase(get(), get()) }
    single { GetUserEventsUseCase(get(), get()) }
}

val dataModule = module {
    //DATA SOURCES
    single { GithubDataSource(get()) as GithubRepository }

    //remote
    single { GithubRemoteImpl(get(), get(), get(), get()) as GithubRemote }
    single { RepoEntityMapper() }
    single { UserEntityMapper() }
    single { UserEvnetEntityMapper() }
    single {
        GithubServiceFactory.makeGithubBrowserService(
            BuildConfig.DEBUG,
            "https://api.github.com"
        )
    }
}
