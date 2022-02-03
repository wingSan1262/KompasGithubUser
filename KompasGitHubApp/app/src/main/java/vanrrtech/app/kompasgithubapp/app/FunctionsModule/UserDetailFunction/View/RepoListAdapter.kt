package vanrrtech.app.kompasgithubapp.app.FunctionsModule.UserDetailFunction.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import vanrrtech.app.kompasgithubapp.R
import vanrrtech.app.kompasgithubapp.app.FunctionsModule.UserDetailFunction.Model.UserRepoDetails
import vanrrtech.app.kompasgithubapp.databinding.RvChildUserRepoBinding

class RepoListAdapter (context: Context) : RecyclerView.Adapter<RepoListAdapter.RepoListAdapterHolder>() {

    lateinit var mContext : Context
    var mList = ArrayList<UserRepoDetails>()

    init{
        mContext = context
    }

    fun onAddRepoItem (item : UserRepoDetails){
        mList.add(0, item)
        notifyItemInserted(0)
    }

    class RepoListAdapterHolder (_binding : RvChildUserRepoBinding) : RecyclerView.ViewHolder(_binding.root) {

        var binding : RvChildUserRepoBinding? = null
        init {
            binding = _binding
        }
        fun setUI(context: Context, item: UserRepoDetails){
            // bind and set your UI content here
            binding?.repoName?.text = item.name
            binding?.repoDesc?.text = item.description
            binding?.repoStar?.text = item.watcher_count.toString()
            var updateAt = item.update_at
            binding?.repoLastUpdate?.text = "last update ${updateAt.substring(0, updateAt.indexOf("T"))}"
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListAdapterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val mBinding : RvChildUserRepoBinding = DataBindingUtil.inflate(layoutInflater, R.layout.rv_child_user_repo, parent, false)
        return  RepoListAdapterHolder(mBinding)
    }

    override fun onBindViewHolder(holder: RepoListAdapterHolder, position: Int) {
        holder.setUI(mContext, mList.get(position))
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}


