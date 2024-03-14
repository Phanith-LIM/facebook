package com.app.facebook
import com.app.facebook.Model.ProfileModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("profile.json")
    fun getProfile(): Call<ProfileModel?>?
}