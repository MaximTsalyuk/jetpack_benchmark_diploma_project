package com.example.jetpack_benchmark_diploma_project.views.home

import UserService
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_benchmark_diploma_project.models.UserModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class home_view_model: ViewModel() {
    private val _userList = mutableStateListOf<UserModel>()
    val userList: List<UserModel>
        get() = _userList

    var selectedIndex: Int? by mutableStateOf(null)

    var errorMessage: String by mutableStateOf("")
    var isBusy: Boolean by mutableStateOf(false)

    fun getUserList() {
        viewModelScope.launch {
            val usersFetchStartTimestampFormat = SimpleDateFormat("'Date\n'dd-MM-yyyy '\n\nand\n\nTime\n'HH:mm:ss:ms")

            val usersFetchStartTimestamp = usersFetchStartTimestampFormat.format(Date())
            Log.d("Users Fetch Start Timestamp: ", usersFetchStartTimestamp)

            isBusy = true

            val userService = UserService.getInstance()
            try {
                _userList.clear()
                _userList.addAll(userService.getUsers(userAmount = 1000).results)

                isBusy = false

                val usersFetchEndTimestampFormat = SimpleDateFormat("'Date\n'dd-MM-yyyy '\n\nand\n\nTime\n'HH:mm:ss:ms")

                val usersFetchEndTimestamp = usersFetchStartTimestampFormat.format(Date())
                Log.d("Users Fetch Start Timestamp: ", usersFetchEndTimestamp)
            } catch (e: Exception) {
                isBusy = false
                errorMessage = e.message.toString()
            }
        }
    }

    fun selectUser(newIndex: Int?) {
        selectedIndex = newIndex

        if (newIndex != null) {
            val navigationStartTimestampFormat = SimpleDateFormat("'Date\n'dd-MM-yyyy '\n\nand\n\nTime\n'HH:mm:ss:ms")

            val navigationStartTimestamp = navigationStartTimestampFormat.format(Date())
            Log.d("Navigation Start Timestamp: ", navigationStartTimestamp)
        }
    }
}