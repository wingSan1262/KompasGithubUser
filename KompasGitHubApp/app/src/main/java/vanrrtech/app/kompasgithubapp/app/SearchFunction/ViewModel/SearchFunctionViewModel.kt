package vanrrtech.app.kompasgithubapp.app.SearchFunction.ViewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.UserItem

class SearchFunctionViewModel : ViewModel() {

    val userItem = GitUserRemoteRepository.getUserRemoteRepo().getRecentUsers().asLiveData()
    var searchItem  = MutableLiveData<UserItem?>()

    fun searchUser(name : String){
        runBlocking {
            GitUserRemoteRepository.getUserRemoteRepo().getSearchedUser("user%3A$name").collect {
                searchItem.postValue(it)
            }
        }
    }
}