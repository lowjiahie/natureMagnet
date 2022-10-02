package com.example.naturemagnet.datagenerator

import androidx.lifecycle.LiveData
import com.example.naturemagnet.entity.Admin
import com.example.naturemagnet.entity.Customer

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

        fun getAdmins(): List<Admin>{
            return listOf(
                Admin("Meng","meng5@gmail.com","0153134124","123asd","Jalan Kuala Lumpur"),
                Admin("Jingsen","jingsen@gmail.com","0153134124","123asd","Jalan Malaysia 1"),
                Admin("Qing Qing","qingqing1@gmail.com","0153134124","123asd","Jalan Malaysia 5"),
                Admin("Jing Den","jingen@gmail.com","0153134124","123asd","Jalan Malaysia 9")
            )
        }

    }
}