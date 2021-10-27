package com.rp.usermanagerp.services

import com.rp.usermanagerp.model.UserModel
import retrofit2.Call
import retrofit2.http.*

interface IUser {
    @GET("/users/")
    fun getUsers(): Call<ArrayList<UserModel>>

    @GET("/users/{id}")
    fun getUserById(@Path("id")id: String): Call<UserModel>

    @PUT("/users/{id}")
    fun putUserById(@Path("id")id: String, @Body body: UserModel): Call<UserModel>

    @POST("/users/")
    fun postUser(@Body body: UserModel): Call<UserModel>

    @DELETE("/users/{id}")
    fun deleteUser(@Path("id") id: String): Call<UserModel>
}