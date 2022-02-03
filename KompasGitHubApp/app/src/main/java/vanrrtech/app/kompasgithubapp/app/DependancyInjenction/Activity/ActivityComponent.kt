package vanrrtech.app.kompasgithubapp.app.DependancyInjenction.Activity

import dagger.Subcomponent
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.SearchFunction.View.MainActivity
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.UserDetailFunction.View.UserDetailActivity

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(context: MainActivity)
    fun inject(context: UserDetailActivity)

}