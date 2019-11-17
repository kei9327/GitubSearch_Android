package kr.wayde.githubsearch.romote

import kr.wayde.githubsearch.romote.model.RepoModel
import kr.wayde.githubsearch.romote.model.UserModel
import io.reactivex.Single
import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.romote.model.UserEventModel
import kr.wayde.githubsearch.romote.model.UsersResultModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("/search/users")
    fun searchUsers(@Query(value = "q") query: String, @Query(value = "page") page: Int,
                    @Query(value = "per_page") perPage: Int): Single<UsersResultModel>

    @GET("/users/{userName}/events")
    fun getUserEvents(@Path("userName") userName: String): Single<List<UserEventModel>>

    @GET("/searchUsers/{userName}")
    fun getUserInfo(@Path("userName") userName: String): Single<UserModel>

    @GET("/searchUsers/{userName}/repos")
    fun getUserRepos(@Path("userName") userName: String): Single<List<RepoModel>>
}
