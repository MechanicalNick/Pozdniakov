package com.pozdniakov.movieviewer.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pozdniakov.movieviewer.data.database.dao.MovieDescriptionDao
import com.pozdniakov.movieviewer.data.database.entity.MovieDescriptionEntity

@Database(
    entities = [MovieDescriptionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDescriptionDatabase : RoomDatabase(){
    abstract fun movieDescriptionDao(): MovieDescriptionDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDescriptionDatabase ?= null
        fun getDataBase(context: Context) : MovieDescriptionDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDescriptionDatabase::class.java,
                    "movie_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}