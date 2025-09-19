package ug.go.ugpass.userregistrationlivedataapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ug.go.ugpass.userregistrationlivedataapp.data.dao.UserDao
import ug.go.ugpass.userregistrationlivedataapp.data.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "user_db"
                ).build()
            }
    }
}