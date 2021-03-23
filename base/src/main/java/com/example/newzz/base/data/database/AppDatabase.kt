package com.example.newzz.base.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newzz.base.data.database.dao.NewsDao
import com.example.newzz.base.data.model.NewsArticlesModel
import com.example.newzz.base.data.model.NewsSourceConverter

@Database(entities = [
    NewsArticlesModel::class
], version = 1, exportSchema = true)
@TypeConverters(NewsSourceConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getRoom(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return INSTANCE as AppDatabase
        }

        fun destroyRoom() {
            INSTANCE = null
        }
    }
}