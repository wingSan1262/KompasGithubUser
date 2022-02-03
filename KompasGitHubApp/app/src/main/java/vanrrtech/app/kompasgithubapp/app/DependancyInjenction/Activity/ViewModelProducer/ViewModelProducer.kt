package vanrrtech.app.kompasgithubapp.app.DependancyInjenction.Activity.ViewModelProducer

import android.app.Application
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.UserItem
import vanrrtech.app.kompasgithubapp.app.SearchFunction.ViewModel.SearchFunctionViewModel
import vanrrtech.app.kompasgithubapp.app.SearchFunction.ViewModel.SearchFunctionViewModelFactory
import vanrrtech.app.kompasgithubapp.app.UserDetailFunction.ModelView.ViewModelUserDetailsActivity

class ViewModelProducer (private val mRepo : GitUserRemoteRepository, private val application: Application ){

    fun getViewModelUserList(): SearchFunctionViewModelFactory {
        return SearchFunctionViewModelFactory(application, mRepo)
    }

    fun getViewModelUserDetail(userItem : UserItem): ViewModelUserDetailsActivity {
        return ViewModelUserDetailsActivity(mRepo, userItem, application)
    }


}