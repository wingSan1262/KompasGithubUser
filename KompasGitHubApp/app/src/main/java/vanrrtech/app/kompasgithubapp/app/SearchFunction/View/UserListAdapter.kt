package vanrrtech.app.kompasgithubapp.app.SearchFunction.View

import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vanrrtech.app.kompasgithubapp.R
import vanrrtech.app.kompasgithubapp.app.SearchFunction.Model.UserItem
import vanrrtech.app.kompasgithubapp.databinding.RvChildUserItemBinding

class UserListAdapter (context: Context) : RecyclerView.Adapter<UserListAdapter.UserListAdapterHolder>() {

    lateinit var mContext : Context
    var mList = ArrayList<UserItem>()
    var searchedList = ArrayList<UserItem>()
    var defaultList = ArrayList<UserItem>()

    init{
        mContext = context
    }

    fun onSearchList (item: UserItem, query : String){

        if(query.isEmpty()){
            mList.clear()
            mList.addAll(defaultList)
            notifyDataSetChanged()
        } else {
            searchedList.add(item)
            mList.addAll(0, searchedList)
            notifyItemInserted(0)
        }
    }

    fun onAddItem (item : UserItem){
        defaultList.add(0, item)
        mList.add(0, item)
        notifyItemInserted(0)
    }

    class UserListAdapterHolder (_binding : RvChildUserItemBinding) : RecyclerView.ViewHolder(_binding.root) {

        var binding : RvChildUserItemBinding? = null
        init {
            binding = _binding
        }
        fun setUI(context: Context, userItem: UserItem){
            Glide.with(context).load(userItem.avatarUrl).into(
                binding!!.profilePict)
            binding!!.nameTv.text = userItem.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val mBinding : RvChildUserItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.rv_child_user_item, parent, false)
        return  UserListAdapterHolder(mBinding)
    }

    override fun onBindViewHolder(holder: UserListAdapterHolder, position: Int) {
        holder.setUI(mContext, mList.get(position))
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}


