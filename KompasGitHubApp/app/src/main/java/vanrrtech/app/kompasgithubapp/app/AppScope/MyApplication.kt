package vanrrtech.app.kompasgithubapp.app.AppScope

import android.app.Application
import android.content.Context
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.Networking.DaggerRemoteRepositoryComponent
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.Networking.NetworkingModule
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.Networking.RemoteRepositoryComponent


class MyApplication : Application() {

    val myNetworkingComponnentDagger : RemoteRepositoryComponent by lazy {
        DaggerRemoteRepositoryComponent.builder().networkingModule(NetworkingModule()).build()
    }
    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
    }

    companion object {
        private var context: Context? = null
        val appContext: Context?
            get() = context
    }
}