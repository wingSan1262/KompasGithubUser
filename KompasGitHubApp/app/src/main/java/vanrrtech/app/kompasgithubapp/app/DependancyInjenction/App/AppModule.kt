package vanrrtech.app.kompasgithubapp.app.DependancyInjenction

import android.app.Application
import dagger.Module
import dagger.Provides
import vanrrtech.app.kompasgithubapp.app.DependancyInjenction.Activity.ViewModelProducer.ViewModelProducer
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.Model.GitUserRemoteRepository

@Module
class AppModule(val application: Application) {

    @Provides
    @AppScope
    fun getGitRepos(): GitUserRemoteRepository {
        return GitUserRemoteRepository()
    }

    @Provides
    fun application() = application

    @Provides
    fun getViewModelFactoryProducer(mRepository: GitUserRemoteRepository,
                                    application : Application) : ViewModelProducer = ViewModelProducer(mRepository, application)



}