package vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.Networking

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.SearchResult
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.UserItem
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.UserDetailFunction.Model.UserRepoDetails

interface GitUserService {

    @GET("users")
    suspend fun getUsersList(): List<UserItem>

    //https://api.github.com/search/
    //q=user%3AwingSan1262&type=Users
    @GET("search/users")
    suspend fun searchUser(@Query("q") searchKey : String, @Query("type") type : String): SearchResult?

    @GET("users/{USERNAME}/repos")
    suspend fun getUserRepos(@Path("USERNAME") userName : String) : List<UserRepoDetails>
}