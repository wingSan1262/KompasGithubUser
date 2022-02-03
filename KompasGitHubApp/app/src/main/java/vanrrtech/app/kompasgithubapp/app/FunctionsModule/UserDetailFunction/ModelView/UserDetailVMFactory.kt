package vanrrtech.app.kompasgithubapp.app.FunctionsModule.UserDetailFunction.ModelView

import android.app.Application
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.UserItem


class UserDetailVMFactory(private val mRepo : GitUserRemoteRepository, application: Application, param: UserItem) :
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