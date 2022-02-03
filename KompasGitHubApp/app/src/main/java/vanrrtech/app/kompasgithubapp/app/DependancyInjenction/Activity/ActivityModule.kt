package vanrrtech.app.kompasgithubapp.app.DependancyInjenction.Activity

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable
import vanrrtech.app.kompasgithubapp.app.DependancyInjenction.Activity.ViewModelProducer.ViewModelProducer
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.GitUserRemoteRepository
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.ViewModel.SearchFunctionViewModel

@Module
class ActivityModule (val activity: AppCompatActivity) {

    @Provides
    fun activity() = activity

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun compositeDisposable() : CompositeDisposable = CompositeDisposable()

    @Provides
    fun getViewModelMainActivity(mRepository: GitUserRemoteRepository,
                               application : Application,
                               viewModelProducer: ViewModelProducer)
    : SearchFunctionViewModel = viewModelProducer.getViewModelUserList().create(
        SearchFunctionViewModel::class.java) /** just for Main Activity**/

}