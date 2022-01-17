package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserItemDbDao {
    @Query("Select * from user_list_db")
    fun loadAllUser() : List<UserItem?>?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers (movie : UserItem)
    @Update
    fun updateUser (movie : UserItem)
    @Delete
    fun deleteUser (movie : UserItem)

    @Query("DELETE FROM user_list_db")
    fun nukeTable()
}