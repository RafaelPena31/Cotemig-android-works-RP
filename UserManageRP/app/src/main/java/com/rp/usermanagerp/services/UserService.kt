package com.rp.usermanagerp.services

import com.rp.usermanagerp.model.UserModel
import com.rp.usermanagerp.services.api.ApiConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class UserService {
    private var retrofitClient: Retrofit = ApiConnection.getRetrofitInstance()
    private var endpoint: IUser = retrofitClient.create(IUser::class.java)

    fun findAll(res: (ArrayList<UserModel>?) -> Unit) {
        endpoint.getUsers().enqueue(object: Callback<ArrayList<UserModel>> {
            override fun onResponse(call: Call<ArrayList<UserModel>>, response: Response<ArrayList<UserModel>>) {
                val list = ArrayList<UserModel>()
                if (response.body() != null && response.body()!!.size > 0)
                    list.addAll(response.body()!!.toList())
                res(list)
            }
            override fun onFailure(call: Call<ArrayList<UserModel>>, t: Throwable) {
                res(null)
            }
        })
    }

    fun findById(id: String, res: (UserModel?) -> Unit) {
        endpoint.getUserById(id).enqueue(object: Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.body() != null)
                    res(response.body())
                else {
                    res(null)
                }
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                res(null)
            }
        })
    }

    fun update(id: String, body: UserModel, res: (UserModel?) -> Unit) {
        endpoint.putUserById(id, body).enqueue(object: Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.body() != null)
                    res(response.body())
                else {
                    res(null)
                }
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                res(null)
            }
        })
    }

    fun create(body: UserModel, res: (UserModel?) -> Unit) {
        endpoint.postUser(body).enqueue(object: Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.body() != null)
                    res(response.body())
                else {
                    res(null)
                }
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                res(null)
            }
        })
    }

    fun delete(id: String, res: (UserModel?) -> Unit) {
        endpoint.deleteUser(id).enqueue(object: Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.body() != null)
                    res(response.body())
                else {
                    res(null)
                }
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                res(null)
            }
        })
    }
}