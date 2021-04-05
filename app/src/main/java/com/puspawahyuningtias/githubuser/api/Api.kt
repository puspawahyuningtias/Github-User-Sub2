package com.puspawahyuningtias.githubuser.api

import com.puspawahyuningtias.githubuser.data.model.DetailUserResponse
import com.puspawahyuningtias.githubuser.data.model.User
import com.puspawahyuningtias.githubuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 6101ed46cd8b25ffc75e18b9b121915619ec3c39")
    fun getSearchUser(
        @Query("q") query: String
    ): Call<UserResponse>
    @GET("users/{username}")
    @Headers("Authorization: token 6101ed46cd8b25ffc75e18b9b121915619ec3c39")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 6101ed46cd8b25ffc75e18b9b121915619ec3c39")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>


    @GET("users/{username}/following")
    @Headers("Authorization: token 6101ed46cd8b25ffc75e18b9b121915619ec3c39")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}