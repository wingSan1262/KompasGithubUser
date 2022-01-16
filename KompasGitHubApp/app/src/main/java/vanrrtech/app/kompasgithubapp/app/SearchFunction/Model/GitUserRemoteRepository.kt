package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitUserRemoteRepository {

    companion object{
        val BASE_URL = "https://api.github.com/"
        val ITEM_DELAY = 300L

        var mRemoteRepo : GitUserRemoteRepository? = null

        fun getUserRemoteRepo(): GitUserRemoteRepository {
            if(mRemoteRepo == null){
                mRemoteRepo = GitUserRemoteRepository()
            }

            return mRemoteRepo!!

        }
    }

    private val userService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GitUserService::class.java)

    fun getRecentUsers() : Flow<UserItem?> {

        return flow {
            var userSource : List<UserItem?>? = userService.getUsersList()

            userSource?.forEach {
                emit(it)
                kotlinx.coroutines.delay(ITEM_DELAY)
            }
        }
    }

    fun getSearchedUser(name: String) : Flow<UserItem?> {
        Log.i("tes", "tes")

        return flow {
            //q=user%3AwingSan1262&type=Users
            var userSource : List<UserItem?>? = userService.searchUser("user%3A$name", "Users")?.items
            Log.i("tes", "tes")
            userSource?.forEach {
                emit(it)
                kotlinx.coroutines.delay(ITEM_DELAY)
            }
        }
    }

}