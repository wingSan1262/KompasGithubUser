package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.Networking

import dagger.Module
import dagger.Provides
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.GitUserRemoteRepository
import javax.inject.Singleton

@Module
class NetworkingModule() {

    @Provides
    @Singleton
    fun getGitUserRemoteRepositoru() = GitUserRemoteRepository()

}