package com.leonchik.android.lab8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import database.TaskDao
import kotlinx.coroutines.launch

class TaskListViewModel (private val taskDao: TaskDao):ViewModel() {

    private val ts=MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = ts

    fun getTasks()
    {
        viewModelScope.launch{
            val tasksList=taskDao.getTask()
            ts.postValue(tasksList)
        }
    }

    fun delTask(task:Task)
    {
        viewModelScope.launch{
            taskDao.delTask(task)
            getTasks()
        }
    }

}