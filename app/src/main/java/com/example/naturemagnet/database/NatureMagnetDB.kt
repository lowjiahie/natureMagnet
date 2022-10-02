package com.example.naturemagnet.database

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.naturemagnet.dao.*
import com.example.naturemagnet.datagenerator.SampleDataGenerator
import com.example.naturemagnet.entity.*
import com.example.naturemagnet.typeconverterClass.ImageConverter
import java.util.concurrent.Executors

//Any new entity please add here
@Database (entities = [Activity::class, ActivityJoined::class, Admin::class, Category::class, Comment::class, Customer::class,
    News::class, NewsSaved::class, Order::class, OrderItem::class, Post::class, PostLiked::class,
    PostSaved::class, Product::class, ProductCategory::class, Reply::class],
    version = 1)
//Any new converter please add here
@TypeConverters(ImageConverter::class)
abstract class NatureMagnetDB : RoomDatabase () {
    //define your DAO here
    abstract fun activityDao(): ActivityDao
    abstract fun customerDao(): CustomerDao

    companion object {
        private var INSTANCE: NatureMagnetDB? = null
        fun getInstance(context: Context): NatureMagnetDB? {
            if (INSTANCE == null) {
                synchronized(NatureMagnetDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NatureMagnetDB::class.java,
                        "natureMagnet.db"
                    ).addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Thread(Runnable {
                                Log.e("Diu Lei Lou Mou", "checked chekded")
                                val db = getInstance(context)!!
                                db.customerDao().insertCustomers(SampleDataGenerator.getCustomers())
                            }).start()
                        }
                    }).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}