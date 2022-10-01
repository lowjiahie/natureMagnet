package com.example.naturemagnet.datagenerator

import android.R.attr.bitmap
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.util.Log
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.ImageRequest
import com.example.naturemagnet.R
import com.example.naturemagnet.entity.*
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext


class SampleDataGenerator {

    companion object {
        fun getCustomers(): List<Customer> {
            return listOf(
                Customer("jiahie", "jiahielow@gmail.com", "0153134124", "123asd", "jalanMalaysia"),
                Customer("kotlin", "kotlin@gmail.com", "0153123124", "123asd", "kotlinMalaysia")
            )
        }

        fun getCustomer(): Customer {
            return Customer(
                "jiahie",
                "jiahielow@gmail.com",
                "0153134124",
                "123asd",
                "jalanMalaysia"
            )
        }

        //generate activities data
      fun injectActivities(context: Context): List<Activity> {
            val listOfImage = listOf(R.drawable.sustainable_cities_development,R.drawable.beach_cleaning,R.drawable.charity_fundraising)
            val bitmapList : MutableList<Bitmap> = mutableListOf()
            var bitmap : Bitmap

            for(image in listOfImage){
                bitmap = BitmapFactory.decodeResource(context.resources,image)
                bitmapList.add(bitmap)
            }
            return listOf(
                Activity(
                    "Sustainable cities development techniques",
                    "Techniques for Sustainable Development",
                    "2022-10-31 9:59:00",
                    "In this event, there will be several industry researchers presenting their founding in how to effectively establish a cities development plan that are sustainable in both for the human and the environment of the cities",
                    "2022-9-31 24:00:00",
                    "2022-9-27 13:39:21",
                    "Pavillion @ Bukit Jalil",
                    bitmapList[0],
                    82,
                    2,
                    1
                ),
                Activity(
                    "Beach Cleaning @ the rimbayu",
                    "Environment Preservation",
                    "2022-11-2 12:35:00",
                    "We will be in cooperation with the local authority to clean the beach located @ the Rimbayu area and aim to recycle all the collected material to improve the quality of the environment.",
                    "2022-10-15 12:00:00",
                    "2022-9-27 14:28:44",
                    "Rimbayu @ Bukit Indah",
                    bitmapList[1],
                    2914,
                    1,
                    2
                ),
                Activity(
                    "Charity fund raising",
                    "Charity Fund Raising",
                    "2022-12-12 19:21:00",
                    "All kind of item will be accepted as a charity goods including tangible & intangible product that could be utilized by the old folks home",
                    "2022-11-15 24:00:00",
                    "2022-9-27 17:21:51",
                    "Chow Kit",
                    bitmapList[2],
                    27,
                    2,
                    1
                )
            )
        }

        fun injectCategories(context: Context): List<Category> {
            var icon: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.photo)

            return listOf(
                Category(
                    "Environmental",
                    "Environmental category include activities that focuses on either preserving & conservation the environment; Preserving refers to action to protects the environment from harmful human activities while Conservation refers to the practice of paving the way for protecting the environment and natural resources regardless of entity size",
                    icon
                ),
                Category(
                    "Charity",
                    "Charity is refers those activities that are primarily aimed for philanthropy and social well-being",
                    icon
                )
            )
        }

        fun injectActivityLiked(): List<ActivityLiked> {
            return listOf(
                ActivityLiked(1, 2, "2022-9-17 23:23:29"),
                ActivityLiked(1, 3, "2022-9-18 23:34:37"),
                ActivityLiked(2, 1, "2022-9-24 23:13:52"),
                ActivityLiked(2, 2, "2022-9-24 23:23:29"),
                ActivityLiked(2, 3, "2022-9-25 00:14:37")
            )
        }

        fun injectActivityJoined(): List<ActivityJoined> {
            return listOf(
                ActivityJoined(1, 3, "2022-9-30 23:34:37"),
                ActivityJoined(2, 1, "2022-9-30 23:13:52")
            )
        }
    }
}