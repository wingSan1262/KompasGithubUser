package vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.ViewModel


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.UserItem

class SearchFunctionViewModel(private val mRepo : GitUserRemoteRepository, application: Application) : AndroidViewModel(
    application
) {


    val userItem = mRepo.getOfflineRecentUsers().asLiveData()
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