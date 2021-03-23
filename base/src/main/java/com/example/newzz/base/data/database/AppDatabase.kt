package com.example.newzz.base.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newzz.base.data.database.dao.NewsDao
import com.example.newzz.base.data.model.NewsArticlesModel
import com.example.newzz.base.data.model.NewsSourceConverter
import kotlinx.coroutines.CoroutineScope

@Database(entities = [
    NewsArticlesModel::class
], version = 1, exportSchema = true)
@TypeConverters(NewsSourceConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context, scope: CoroutineScope): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
