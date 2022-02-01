package vanrrtech.app.kompasgithubapp.app.SearchFunction.ViewModel


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import vanrrtech.app.kompasgithubapp.app.AppScope.MyApplication
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.UserItem

class SearchFunctionViewModel(private val mRepo : GitUserRemoteRepository, application: Application) : AndroidViewModel(
    application
) {


    val userItem = mRepo.getRecentUsers().asLiveData()
    var searchItem  = MutableLiveData<UserItem?>()

    fun searchUser(name : String){
        runBlocking {
            try {
                mRepo.getSearchedUser("user:${name}").collect {
                    searchItem.postValue(it)
                }
            } catch (e : Throwable){
                Log.i("Log", "${e.cause } the message was  ${e.message}")
            }

        }
    }
}