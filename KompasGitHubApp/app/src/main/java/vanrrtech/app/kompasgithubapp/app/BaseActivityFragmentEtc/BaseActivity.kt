package vanrrtech.app.kompasgithubapp.app.BaseActivityFragmentEtc

import androidx.appcompat.app.AppCompatActivity
import vanrrtech.app.kompasgithubapp.app.AppScope.MyApplication
import vanrrtech.app.kompasgithubapp.app.DependancyInjenction.Activity.ActivityComponent
import vanrrtech.app.kompasgithubapp.app.DependancyInjenction.Activity.ActivityModule
import vanrrtech.app.kompasgithubapp.app.DependancyInjenction.AppComponent

open class BaseActivity : AppCompatActivity() {

    val appComponent : AppComponent by lazy {
        (application as MyApplication).myAppComponent
    }

    val activityComponent : ActivityComponent by lazy {
        appComponent.newActivityComponent(ActivityModule(this))
    }
}