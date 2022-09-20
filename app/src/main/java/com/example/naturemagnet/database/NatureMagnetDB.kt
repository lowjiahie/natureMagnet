//package com.example.naturemagnet.database
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.naturemagnet.dao.*
//import com.example.naturemagnet.entity.*
//
//@Database (entities = [Activity::class], version = 1)
//abstract class NatureMagnetDB : RoomDatabase () {
//    abstract fun activityDao(): ActivityDao
//
//    companion object {
//        private var INSTANCE: NatureMagnetDB? = null
//        fun getInstance(context: Context): NatureMagnetDB? {
//            if (INSTANCE == null) {
//                synchronized(NatureMagnetDB::class) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        NatureMagnetDB::class.java,
//                        "natureMagnet.db"
//                    )
//                        .allowMainThreadQueries()
//                        .build()
//                }
//            }
//            return INSTANCE
//        }
//
//        fun destroyInstance() {
//            INSTANCE = null
//        }
//    }
//}