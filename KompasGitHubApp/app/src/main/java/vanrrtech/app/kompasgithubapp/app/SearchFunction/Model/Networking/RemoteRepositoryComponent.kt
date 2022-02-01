package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.Networking

import dagger.Component
import vanrrtech.app.kompasgithubapp.app.SearchFunction.View.MainActivity
import vanrrtech.app.kompasgithubapp.app.UserDetailFunction.View.UserDetailActivity
import javax.inject.Singleton

@Singleton
@Component (modules = [NetworkingModule::class])
interface RemoteRepositoryComponent {
    fun inject(context: MainActivity)
    fun inject(context: UserDetailActivity)
}