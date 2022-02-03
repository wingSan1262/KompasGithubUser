package vanrrtech.app.kompasgithubapp.app.FunctionsModule.UserDetailFunction.Model

import com.google.gson.annotations.SerializedName

data class UserRepoDetails(
    @SerializedName("name")
    var name : String,

    @SerializedName("description")
    var description : String,
    @SerializedName("watcher_count")
    var watcher_count : Int,
    @SerializedName("updated_at")
    var update_at : String
)
