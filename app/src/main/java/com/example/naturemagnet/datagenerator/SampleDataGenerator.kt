package com.example.naturemagnet.datagenerator

import com.example.naturemagnet.entity.Customer

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

    }
}