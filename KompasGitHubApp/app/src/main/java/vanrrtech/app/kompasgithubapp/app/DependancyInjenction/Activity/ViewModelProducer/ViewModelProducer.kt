package vanrrtech.app.kompasgithubapp.app.DependancyInjenction.Activity.ViewModelProducer

import android.app.Application
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.UserItem
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.ViewModel.SearchFunctionViewModelFactory
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.UserDetailFunction.ModelView.ViewModelUserDetailsActivity

class ViewModelProducer (private val mRepo : GitUserRemoteRepository, private val application: Application ){

    fun getViewModelUserList(): SearchFunctionViewModelFactory {
        return SearchFunctionViewModelFactory(application, mRepo)
    }

    fun getViewModelUserDetail(userItem : UserItem): ViewModelUserDetailsActivity {
        return ViewModelUserDetailsActivity(mRepo, userItem, application)
    }


}