package kr.wayde.githubsearch.romote

import io.reactivex.Single
import kr.wayde.githubsearch.domain.entity.Starred
import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.romote.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("/search/users")
    fun searchUsers(
        @Query(value = "q") query: String, @Query(value = "page") page: Int,
        @Query(value = "per_page") perPage: Int
    ): Single<UsersResultModel>

    @GET("/users/{userName}/events")
    fun getUserEvents(@Path("userName") userName: String): Single<List<UserEventModel>>

    @GET("/searchUsers/{userName}")
    fun getUserInfo(@Path("userName") userName: String): Single<UserModel>

    @GET("/users/{user}/repos")
    fun getUserRepos(
        @Path("user") query: String,
        @Query(value = "page") page: Int,
        @Query(value = "per_page") perPage: Int
    ): Single<List<RepoModel>>

    @GET("/users/{user}/starred")
    fun getUserStarred(
        @Path("user") query: String,
        @Query(value = "page") page: Int,
        @Query(value = "per_page") perPage: Int
    ): Single<List<StarredModel>>
}
