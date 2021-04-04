package com.puspawahyuningtias.githubuser.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.githubuser.api.RetrofitClient
import com.puspawahyuningtias.githubuser.data.model.User
import com.puspawahyuningtias.githubuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainViewModel : ViewModel() {
    val listUsers = MutableLiveData<ArrayList<User>>()
    fun setSearchUsers(query: String){
        RetrofitClient.apiInstance
            .getSearchUser(query)
            .enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful){
                        listUsers.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.d("Failure", t.message.toString())
                }

            })

    }
    fun getSearchUsers(): LiveData<ArrayList<User>>{
        return listUsers
    }
}