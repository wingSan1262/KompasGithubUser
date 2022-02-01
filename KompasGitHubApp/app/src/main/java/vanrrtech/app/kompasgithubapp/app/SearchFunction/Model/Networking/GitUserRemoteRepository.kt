package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vanrrtech.app.kompasgithubapp.app.AppScope.MyApplication
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.Networking.GitUserService
import vanrrtech.app.kompasgithubapp.app.UserDetailFunction.Model.UserRepoDetails

class GitUserRemoteRepository {

    companion object{
        val BASE_URL = "https://api.github.com/"
        val ITEM_DELAY = 300L
    }

    // Online Repo Client
    var logging =  HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY);
    var mClient = OkHttpClient.Builder().addInterceptor(logging)
    private val userService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(mClient.build())
        .build()
        .create(GitUserService::class.java)

    // Room DB
    val userDb = UsersItemDb.getInstance(MyApplication.appContext!!)
    val userDao = userDb?.userItemDao()



    fun getOfflineRecentUsers() : Flow<UserItem?> {
        var offlineRes : List<UserItem?>? = null
        CoroutineScope(Dispatchers.IO).launch {
            offlineRes = userDao?.loadAllUser()
        }

        return flow {
            var userSource = ArrayList<UserItem?>()
            try {
                userSource.addAll(userService.getUsersList())
            } catch (e : Throwable){
                Log.e("Internet down", "error")
            }

            if(userSource?.isEmpty()){
                userSource.addAll(0, offlineRes!!)
            }
            userSource?.forEach {
                emit(it)
                it?.let { it1 ->
                    var scope = CoroutineScope(Dispatchers.IO)
                    scope.launch(Dispatchers.IO){
                        userDao?.insertUsers(it1)
                    }
                }
                kotlinx.coroutines.delay(ITEM_DELAY)
            }
        }
    }
    fun getSearchedUser(name: String) : Flow<UserItem?> {
        Log.i("Log", "name")

        return flow {
            //q=user%3AwingSan1262&type=Users
            var response : SearchResult? = null
            try {
                response = userService.searchUser(name, "Users")
            } catch (throwable : Throwable){
                Log.e("Internet down", "error")
            }
            Log.i("us", "response total ${response?.total}, response item ${response?.items.toString()}")
            response?.items?.forEach {
                emit(it)
                kotlinx.coroutines.delay(ITEM_DELAY)
            }
        }
    }

    fun getUserRepoDetail(userName: String) : Flow<UserRepoDetails?> {
        Log.i("Log", "name")

        return flow {
            //q=user%3AwingSan1262&type=Users
            var response  = ArrayList<UserRepoDetails>()
            try {
                response.addAll(0,userService.getUserRepos(userName))
            } catch (throwable : Throwable){
                Log.e("Internet down", "error")
            }

            response?.forEach {
                emit(it)
                kotlinx.coroutines.delay(ITEM_DELAY)
            }
        }
    }

}