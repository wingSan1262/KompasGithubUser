package vanrrtech.app.kompasgithubapp.app.FunctionsModule.UserDetailFunction.ModelView

import android.app.Application
import androidx.lifecycle.*
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.UserItem

class ViewModelUserDetailsActivity(private val mRepo : GitUserRemoteRepository, user: UserItem, application: Application) : AndroidViewModel(
    application
) {

    var userRepo = mRepo.getUserRepoDetail(user.login).asLiveData()
}