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
    News::class, NewsSaved::class, Post::class, PostLiked::class, PostSaved::class, Product::class, Reply::class],
    version = 1)
//Any new converter please add here
@TypeConverters(ImageConverter::class)
abstract class NatureMagnetDB : RoomDatabase () {
    //define your DAO here
    abstract fun activityDao(): ActivityDao
    abstract fun customerDao(): CustomerDao
    abstract fun adminDao(): AdminDao
//    abstract fun productCategoryDao(): ProductCategoryDao
    abstract fun productDao(): ProductDao
//    abstract fun orderDao(): OrderDao
//    abstract fun orderItemDao(): OrderItemDao

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
                                val db = getInstance(context)!!
                                db.customerDao().insertCustomer(SampleDataGenerator.getCustomers())
                                db.adminDao().insertAdmin(SampleDataGenerator.getAdmins())
//                                db.productCategoryDao().insertProdCats(SampleDataGenerator.getProductCategory())
                                db.productDao().insertProducts(SampleDataGenerator.getProducts(context))
//                                db.orderDao().insertOrders(SampleDataGenerator.getOrders())
//                                db.orderItemDao().insertOrderItems(SampleDataGenerator.getOrderItems())
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