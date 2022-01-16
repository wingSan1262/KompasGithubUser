package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model

import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("login")
    var login : String,

    @SerializedName("id")
    var id : Int,

    @SerializedName("avatar_url")
    var avatarUrl : String,

    @SerializedName("url")
    var url : String,

    @SerializedName("repos_url")
    var repos_url : String,
)
