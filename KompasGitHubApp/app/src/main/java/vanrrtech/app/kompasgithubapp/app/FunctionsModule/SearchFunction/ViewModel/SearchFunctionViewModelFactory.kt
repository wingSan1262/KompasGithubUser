package vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.GitUserRemoteRepository


class SearchFunctionViewModelFactory(val mApplication: Application, val repo : GitUserRemoteRepository) :
    ViewModelProvider.Factory {
    private val mRepo by lazy {
        repo
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchFunctionViewModel(mRepo, mApplication) as T
    }

}