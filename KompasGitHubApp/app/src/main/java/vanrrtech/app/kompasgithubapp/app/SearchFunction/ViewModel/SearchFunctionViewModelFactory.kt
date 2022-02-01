package vanrrtech.app.kompasgithubapp.app.SearchFunction.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.UserItem


class SearchFunctionViewModelFactory(val mApplication: Application, val repo : GitUserRemoteRepository) :
    ViewModelProvider.Factory {
    private val mRepo by lazy {
        repo
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchFunctionViewModel(mRepo, mApplication) as T
    }

}