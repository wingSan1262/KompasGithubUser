package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.Networking

import dagger.Module
import dagger.Provides
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.GitUserRemoteRepository

@Module
class NetworkingModule() {

    @Provides
    fun getGitUserRemoteRepositoru() = GitUserRemoteRepository()

}