package com.puspawahyuningtias.githubuser.api

import com.puspawahyuningtias.githubuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 6101ed46cd8b25ffc75e18b9b121915619ec3c39")
    fun getSearchUser(
        @Query("q") query: String
    ): Call<UserResponse>
}