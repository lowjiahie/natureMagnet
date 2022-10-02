package com.example.naturemagnet.datagenerator

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.naturemagnet.R
import com.example.naturemagnet.entity.*
import java.security.AccessController.getContext

class SampleDataGenerator {

    companion object {
        fun getCustomers(): List<Customer>{
            return listOf(
                Customer("jiahie","jiahielow@gmail.com","0153134124","123asd","jalanMalaysia"),
                Customer("kotlin","kotlin@gmail.com","0153123124","123asd","kotlinMalaysia"),
                Customer("wenxin","wenxin1@gmail.com","0153134124","123asd","Jalan Kuala Lumpur 1"),
                Customer("jingchong","jingchong1@gmail.com","0153134124","123asd","Jalan Kuala Lumpur 2")
            )
        }
        fun getCustomer(): Customer{
            return Customer("jiahie","jiahielow@gmail.com","0153134124","123asd","jalanMalaysia")
        }

        fun injectNews() : List<News>{
            return listOf(
                News("‘This must stop’: Albanese hints at climate change talks with King Charles III", "http://www.climate-news-db.com/article/4427", "Sky News Australia", "2022-09-18"),
                News("Most candidates prepared to spend ratepayer money on climate change initiatives", "http://www.climate-news-db.com/article/5101", "Stuff.co.nz", "2022-09-18"),
                News("China lost its Yangtze River dolphin. Climate change is coming for other species next", "http://www.climate-news-db.com/article/2840", "CNN", "2022-09-18"),
                News("Liz Truss energy plan ‘shows government doesn’t understand climate crisis’", "http://www.climate-news-db.com/article/7395", "The Independent", "2022-09-17"),
                News("Australia should aim for net zero by 2040, new Climate Change Authority member says | Climate crisis | The Guardian", "http://www.climate-news-db.com/article/871", "The Guardian", "2022-09-16"),
                News("People don’t really talk about climate change. Here’s how to start.", "http://www.climate-news-db.com/article/7888", "The Washington Post", "2022-09-16"),
                News("Refreezing poles to help reverse climate crisis is possible, scientists claim", "http://www.climate-news-db.com/article/7394", "The Independent", "2022-09-16"),
                News("Global warming, man-made factors worsened Pakistan floods: Study", "http://www.climate-news-db.com/article/1947", "Al Jazeera", "2022-09-16"),
                News("Climate change worsened Pakistan flood impact", "http://www.climate-news-db.com/article/6165", "The New Zealand Herald", "2022-09-16"),
                News("Climate change could spell 'disaster' for at-risk marine populations", "http://www.climate-news-db.com/article/5102", "Stuff.co.nz", "2022-09-15"),
                News("Extreme hunger soaring in world’s climate hotspots, says Oxfam | Climate crisis | The Guardian", "http://www.climate-news-db.com/article/868", "The Guardian", "2022-09-15"),
                News("Climate Change Linked to Pakistan’s Floods, Study Finds", "http://www.climate-news-db.com/article/1462", "The New York Times", "2022-09-15"),
            )
        }

        fun injectNewsSaved() : List<NewsSaved>{
            return listOf(
                NewsSaved(1,1, "2022-10-21 12:00:00"),
                NewsSaved(1,2,"2022-09-18 13:10:00"),
                NewsSaved(1,3,"2022-09-20 13:10:00"),
                NewsSaved(2,4,"2022-09-19 15:20:00"),
                NewsSaved(2,5,"2022-09-20 16:30:00"),
                NewsSaved(2,6,"2022-09-25 13:10:00")
            )
        }


        fun injectPost(context : Context): List<Post>{

            val listOfImage = listOf(R.mipmap.post1,R.mipmap.post2,R.mipmap.post3,R.mipmap.post4)
            val bitmapList : MutableList<Bitmap> = mutableListOf()
            var bitmap : Bitmap

            for(image in listOfImage){
                bitmap = BitmapFactory.decodeResource(context.resources,image)
                bitmapList.add(bitmap)
            }

            val content1 = "1.Carpooling 2.Go Green 3.Cut back on flying 4.Reduce your energy use"
            val content2 = "The world temperature being increasing, we are trying to solve this isses"
            val content3 = "Save earth, we can launch recycle program to increasing the awareness of climate action"
            val content4 = "Make our life easy"

            return listOf(
                Post("Steps to rescue Climate Change", content1, bitmapList[0], null, 0, "2022-09-28", 1),
                Post("Help World!! Save World!!", content2, bitmapList[1], null, 0, "2022-09-29", 1),
                Post("Save Earth!!", content3, bitmapList[2], null, 0, "2022-10-01", 2),
                Post("Life is going be ok!", content4, bitmapList[3], null, 0, "2022-10-01", 2)
            )
        }

        fun injectPostLiked(): List<PostLiked>{

            return listOf(
                PostLiked(1,1,"2022-09-30 10:23:00"),
                PostLiked(1,3,"2022-10-02 11:23:00"),
                PostLiked(1,4,"2022-10-01 15:10:00"),
                PostLiked(2,1,"2022-09-28 10:00:00"),
                PostLiked(2,2,"2022-09-28 11:40:00"),
            )
        }

        fun injectPostSaved(): List<PostSaved>{

            return listOf(
                PostSaved(1,1,"2022-09-30 10:23:00"),
                PostSaved(1,3,"2022-10-02 11:23:00"),
                PostSaved(2,1,"2022-09-28 10:00:00"),
                PostSaved(2,2,"2022-09-28 11:40:00"),
            )
        }

        fun injectComment() :List<Comment>{

            return listOf(
                Comment("hello 123","2022-09-28 10:23:00",null,1,1),
                Comment("Hello world 2","2022-09-29 10:23:00",null,2,1),
                Comment("Hello world 3","2022-10-01 11:30:00",null,1,3),
                Comment("Hello world 4","2022-10-02 13:00:00",null,2,2),
                Comment("Hello world 5","2022-09-30 10:23:00",null,1,2),
            )
        }




    }
}