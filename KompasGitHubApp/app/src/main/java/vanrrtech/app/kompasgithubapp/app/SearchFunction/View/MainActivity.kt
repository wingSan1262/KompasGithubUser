package vanrrtech.app.kompasgithubapp.app.SearchFunction.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import vanrrtech.app.kompasgithubapp.R
import vanrrtech.app.kompasgithubapp.app.SearchFunction.ViewModel.SearchFunctionViewModel
import vanrrtech.app.kompasgithubapp.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : SearchFunctionViewModel
    private val userList = UserListAdapter(this)

    val mCompositeDisposable = CompositeDisposable()

    private var _mBinder : ActivityMainBinding? = null

    private var isSearching = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _mBinder = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(SearchFunctionViewModel::class.java)

        _mBinder!!.userRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userList
        }

        observeGitUserRemote()
        addSearchListener()
    }

    private fun observeGitUserRemote(){
        viewModel.userItem.observe(this, Observer { mUserItem ->
            // UI update

            // list update
            userList.onAddItem(mUserItem!!, isSearching)
            _mBinder!!.userRv.smoothScrollToPosition(0)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        this.viewModelStore.clear()
    }

    private fun addSearchListener(){

        var mQuery = ""
        viewModel.searchItem.observe(this, Observer {
            userList.onSearchList(it!!, mQuery)
        })

        mCompositeDisposable.add(
            RxTextView.textChangeEvents(_mBinder!!.searchField)
            .skipInitialValue()
            .debounce(800, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object  : DisposableObserver<TextViewTextChangeEvent>(),
                @io.reactivex.rxjava3.annotations.NonNull Disposable {
                override fun onNext(value: TextViewTextChangeEvent?) {
                    mQuery = value!!.text().toString()
                    if(mQuery.isEmpty()){
                        isSearching = false
                        userList.mList.clear()
                        userList.mList.addAll(0, userList.defaultList)
                        userList.notifyDataSetChanged()
                        return
                    }
                    isSearching = true
                    userList.searchedList.clear()
                    userList.mList.clear()
                    userList.notifyDataSetChanged()
                    viewModel.searchUser(mQuery)
                }

                override fun onError(e: Throwable?) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

            })
        )

    }
}