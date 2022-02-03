package vanrrtech.app.kompasgithubapp.app.DependancyInjenction.Activity

import dagger.Module
import dagger.Subcomponent
import vanrrtech.app.kompasgithubapp.app.SearchFunction.View.MainActivity
import vanrrtech.app.kompasgithubapp.app.UserDetailFunction.View.UserDetailActivity

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(context: MainActivity)
    fun inject(context: UserDetailActivity)

}