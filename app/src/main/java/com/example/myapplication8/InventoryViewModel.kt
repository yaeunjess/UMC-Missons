package com.example.myapplication8

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class InventoryViewModel(private val userDao: UserDao):ViewModel() {
    private fun insertUser(user:User){
        viewModelScope.launch{
            userDao.insert(user)
        }
    }
    private fun getNewUserEntry(name:String):User{
       return User(name = name)
    }
    fun addNewUser(name:String){
        val newUser=getNewUserEntry(name)
        insertUser(newUser)
    }
}

class InventoryViewModelFactory(private val userDao: UserDao): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        TODO("Not yet implemented")
        if(modelClass.isAssignableFrom(InventoryViewModel::class.java)){
            return InventoryViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}