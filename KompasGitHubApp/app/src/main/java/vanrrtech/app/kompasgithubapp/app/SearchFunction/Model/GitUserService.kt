package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model

import retrofit2.http.GET
import retrofit2.http.Query

interface GitUserService {

    @GET("users")
    suspend fun getUsersList(): List<UserItem>

    //https://api.github.com/search/
    //q=user%3AwingSan1262&type=Users
    @GET("search/users")
    suspend fun searchUser(@Query("q") searchKey : String, @Query("type") type : String): SearchResult?
}