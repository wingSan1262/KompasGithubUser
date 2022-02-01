package vanrrtech.app.kompasgithubapp.app.UserDetailFunction.ModelView

import android.app.Application
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.UserItem


class ViewModelFactory(private val mRepo : GitUserRemoteRepository, application: Application, param: UserItem) :
    ViewModelProvider.Factory {
    private val mApplication: Application
    private val mUserInfo: UserItem
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelUserDetailsActivity(mRepo, mUserInfo, mApplication) as T
    }

    init {
        mApplication = application
        mUserInfo = param
    }
}