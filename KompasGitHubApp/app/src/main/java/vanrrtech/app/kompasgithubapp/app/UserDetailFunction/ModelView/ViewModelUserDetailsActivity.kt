package vanrrtech.app.kompasgithubapp.app.UserDetailFunction.ModelView

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.runBlocking
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.UserItem
import vanrrtech.app.kompasgithubapp.app.UserDetailFunction.Model.UserRepoDetails

class ViewModelUserDetailsActivity(user: UserItem, application: Application) : AndroidViewModel(
    application
) {

    var userRepo = GitUserRemoteRepository.getUserRemoteRepo().getUserRepoDetail(user.login).asLiveData()
}