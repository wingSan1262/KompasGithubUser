package vanrrtech.app.kompasgithubapp.app.UserDetailFunction.View

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import vanrrtech.app.kompasgithubapp.R
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.UserItem
import vanrrtech.app.kompasgithubapp.app.UserDetailFunction.ModelView.ViewModelUserDetailsActivity
import vanrrtech.app.kompasgithubapp.app.UserDetailFunction.ModelView.ViewModelFactory
import vanrrtech.app.kompasgithubapp.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {

    companion object{
        val USER_PARAM_INTENT = "passing-user-param-serialized";
    }

    lateinit var _mBinder : ActivityUserDetailBinding
    lateinit var viewModel : ViewModelUserDetailsActivity
    var mRepoList = RepoListAdapter(this)

    var userInfo : UserItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        _mBinder = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        userInfo = intent.getSerializableExtra(USER_PARAM_INTENT) as UserItem?

        viewModel = ViewModelFactory(this.application, userInfo!!).create(ViewModelUserDetailsActivity::class.java)

        _mBinder!!.userRepoRv.apply {
            layoutManager = LinearLayoutManager(this@UserDetailActivity)
            adapter = mRepoList
        }
        setUserInfo()

        observeGitUserRemote()

    }

    private fun setUserInfo(){
        Glide.with(this).load(userInfo?.avatarUrl).into(
            _mBinder?.userImage)
        _mBinder?.userName.text = userInfo?.login
        _mBinder?.userAccountId.text = "@${userInfo?.login}"
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModelStore
    }

    private fun observeGitUserRemote(){
        viewModel.userRepo.observe(this, Observer { mRepoItem ->
            _mBinder.repoNullTv.visibility = View.GONE
            mRepoList.onAddRepoItem(mRepoItem!!)
            _mBinder!!.userRepoRv.smoothScrollToPosition(0)
        })
    }
}