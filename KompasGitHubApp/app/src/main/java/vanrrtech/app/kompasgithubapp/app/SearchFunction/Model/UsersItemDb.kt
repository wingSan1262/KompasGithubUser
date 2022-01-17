package vanrrtech.app.kompasgithubapp.app.SearchFunction.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserItem::class], exportSchema = false, version = 1)
public abstract class UsersItemDb : RoomDatabase() {
    companion object {
        val DB_NAME: String = "users_db"
        private var instance: UsersItemDb? = null

        fun getInstance(context: Context): UsersItemDb? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    UsersItemDb::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }

    public abstract fun userItemDao(): UserItemDbDao
}