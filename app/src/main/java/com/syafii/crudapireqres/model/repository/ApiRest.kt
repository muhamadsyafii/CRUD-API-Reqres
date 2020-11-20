package com.syafii.crudapireqres.model.repository

import com.syafii.crudapireqres.model.ResponseUser
import com.syafii.crudapireqres.model.User
import com.syafii.crudapireqres.model.listuser.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiRest {

    @POST("api/users")
    fun createUser(@Body user : User) : Call<ResponseUser>

    @GET("api/users")
    fun listUser() : Call<UserResponse>

    @POST("api/login")
    fun login(@Body user: User) : Call<ResponseUser>

    @PUT("/api/users/2")
    fun updateUser(@Body user: User) : Call<ResponseUser>

    
}