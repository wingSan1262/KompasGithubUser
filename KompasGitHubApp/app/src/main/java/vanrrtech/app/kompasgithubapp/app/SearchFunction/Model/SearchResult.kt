package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("items")
    var items : List<UserItem?>,

    @SerializedName("total_count")
    var total : Int
)
