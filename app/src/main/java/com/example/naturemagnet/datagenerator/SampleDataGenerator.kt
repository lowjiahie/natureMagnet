package com.example.naturemagnet.datagenerator

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.example.naturemagnet.R
import com.example.naturemagnet.entity.*

class SampleDataGenerator {

    companion object {
        fun getCustomers(): List<Customer>{
            return listOf(
                Customer("jiahie","jiahielow@gmail.com","0153134124","123asd","jalanMalaysia"),
                Customer("kotlin","kotlin@gmail.com","0153123124","123asd","kotlinMalaysia")
            )
        }
        fun getCustomer(): Customer{
            return Customer("jiahie","jiahielow@gmail.com","0153134124","123asd","jalanMalaysia")
        }

        fun getAdmins(): List<Admin>{
            return listOf(
                Admin("Meng","meng5@gmail.com","0153134124","123asd","Jalan Kuala Lumpur"),
                Admin("Jingsen","jingsen@gmail.com","0153134124","123asd","Jalan Malaysia 1"),
                Admin("Qing Qing","qingqing1@gmail.com","0153134124","123asd","Jalan Malaysia 5"),
                Admin("Jing Den","jingen@gmail.com","0153134124","123asd","Jalan Malaysia 9")
            )
        }

//        fun getProductCategory(): List<ProductCategory>{
//
//            return listOf(
//                ProductCategory("Bathroom"),
//                ProductCategory("Fashion"),
//                ProductCategory("Others")
//            )
//        }

        fun getProducts(context:Context): List<Product>{
            val listOfImage = listOf(R.mipmap.towel,R.mipmap.yoga_mat,R.mipmap.toothbrush,R.mipmap.bag, R.mipmap.wallet, R.mipmap.steel_bottle)
            val bitmapList : MutableList<Bitmap> = mutableListOf()
            var bitmap : Bitmap


            for(image in listOfImage){
                bitmap = BitmapFactory.decodeResource(context.resources,image)
                bitmapList.add(bitmap)
            }


            return listOf(
                Product("Wool Blanket", "RM 30", "55% recycled wool, 30% recycled polyester, 15% recycled other fibres. For every blanket sold, we donate RM15 to the Asylum Seeker Resource Centre", 20,  bitmapList[0], 1),
                Product("Yoga Mat", "RM 40", "95% Recycled Mat. For every yoga mat sold, we donate RM20 to the Asylum Seeker Resource Centre", 20,  bitmapList[1], 2),
                Product("Toothbrush", "RM 25", "99% recycled Toothbrush. For every toothbrush sold, we donate RM10 to the Asylum Seeker Resource Centre", 40,  bitmapList[2], 1),
                Product("Tote Bag", "RM 30", "85% recycled Tote Bag. For every toothbrush sold, we donate RM15 to the Asylum Seeker Resource Centre", 30,  bitmapList[3], 3),
                Product("Wallet", "RM 30", "80% recycled Wallet. For every wallet sold, we donate RM15 to the Asylum Seeker Resource Centre", 35,  bitmapList[4], 3),
                Product("Steel Bottle", "RM 50", "80% recycled Steel Bottle. For every bottle sold, we donate RM25 to the Asylum Seeker Resource Centre", 20,  bitmapList[5], 2)
            )
        }


//        fun getOrders(): List<Order> {
//            return listOf(
//                //order status: pending, confirmed, packaging, delivered
//                Order(
//                    "3 Jun 2022 11:05:30",
//                    "7 Jun 2022 09:30",
//                    "Packaging",
//                    30.00,
//                    "1293847263",
//                    "23, Jalan Kepong Baru",
//                    "0191234567",
//                    "null",
//                    1
//                ),
//                Order(
//                    "10 Jun 2022 11:05:30",
//                    "null",
//                    "Pending",
//                    80.00,
//                    "1234567890",
//                    "Shah Alam",
//                    "0191234567",
//                    "null",
//                    2
//                ),
//                Order(
//                    "20 Jun 2022 11:05:30",
//                    "30 Jun 2022 10:45",
//                    "Packaging",
//                    50.00,
//                    "4736472834",
//                    "Setapak Central",
//                    "0123274598",
//                    "null",
//                    2
//                ),
//                Order(
//                    "30 Jun 2022 11:05:30",
//                    "2 July 2022 15:30",
//                    "Confirmed",
//                    90.00,
//                    "9483746274",
//                    "56, Jalan Utama, Kepong Ulu",
//                    "0165973845",
//                    "null",
//                    1
//                ),
//                Order(
//                    "1 July 2022 11:05:30",
//                    "8 July 2022 12:30",
//                    "Delivered",
//                    60.00,
//                    "8495738475",
//                    "99, Jalan Mewah, Bukit Jalil",
//                    "0194863669",
//                    "8 July 2022 12:35",
//                    2
//                ),
//            )
//        }
//
//        fun getOrderItems() : List<OrderItem> {
//            return listOf(
//                OrderItem(1,1,1),
//                OrderItem(2,2,2),
//                OrderItem(3,3,2),
//                OrderItem(4,4,3),
//                OrderItem(5,5,1)
//            )
//        }
    }
}