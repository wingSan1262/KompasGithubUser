package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.Networking

import dagger.Component
import vanrrtech.app.kompasgithubapp.app.SearchFunction.View.MainActivity

@Component (modules = [NetworkingModule::class])
interface RemoteRepositoryComponent {
    fun inject(context: MainActivity)
}