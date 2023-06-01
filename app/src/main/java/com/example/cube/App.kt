package com.example.cube

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.cube.data.locale.room.AppDatabase

class App: Application() {

    companion object {
       private var context: Context? = null
        private var appDatabase: AppDatabase? = null
        fun getDataIntense(): AppDatabase?{
            if (appDatabase ==  null) {
                appDatabase = context?.let {
                    Room.databaseBuilder(
                        it,
                        AppDatabase::class.java,
                        "note_database"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }

            return appDatabase
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        getDataIntense()
    }
}