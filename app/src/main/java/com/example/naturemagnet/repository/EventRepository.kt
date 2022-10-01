package com.example.naturemagnet.repository

import com.example.naturemagnet.dao.ActivityDao
import com.example.naturemagnet.dao.CategoryDao
import com.example.naturemagnet.entity.Activity
import com.example.naturemagnet.entity.Category

class EventRepository(private val activityDao: ActivityDao, private val categoryDao: CategoryDao) {


    //activity
    fun getAllActivities(): List<Activity> = activityDao.getAll()
    fun getActivity(activityId: Long): Activity = activityDao.getActivity(activityId)
    suspend fun insertActivity(activity: Activity) {
        activityDao.insertActivity(activity)
    }
    suspend fun insertActivities(activities: List<Activity>) {
        return activityDao.insertActivities(activities)
    }
    suspend fun updateActivity(activity: Activity) {
        return activityDao.updateUsers(activity)
    }
    suspend fun deleteActivity(activity: Activity) {
        return activityDao.deleteActivity(activity)
    }

    //category
    fun getAllCategories(): List<Category> = categoryDao.getAll()
    fun getCategory(categoryId: Long): Category = categoryDao.getCategory(categoryId)
    suspend fun insertCategory(category: Category) {
        return categoryDao.insertCategory(category)
    }
    suspend fun insertCategories(category: List<Category>) {
        return categoryDao.insertCategories(category)
    }
    suspend fun updateCategory(category: Category) {
        return categoryDao.updateCategory(category)
    }
    suspend fun deleteCategory(category: Category) {
        return categoryDao.deleteCategory(category)
    }
}