package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("items")
    var items : List<UserItem?>
)
