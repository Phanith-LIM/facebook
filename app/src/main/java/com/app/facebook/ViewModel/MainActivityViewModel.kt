package com.app.facebook.ViewModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.facebook.ApiService
import com.app.facebook.Model.ProfileModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityViewModel: ViewModel() {
    private val userProfile = MutableLiveData<ProfileModel> ()

    fun getProfile() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http:localhost/data.json")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val repository = retrofit.create<ApiService>(ApiService::class.java)
        repository.getProfile().enqueue(object : Callback<ProfileModel> {
            override fun onResponse(call: Call<ProfileModel>, response: Response<ProfileModel>) {
                Log.e("MainActivityViewModel", "Success: ${response.body()}")
            }

            override fun onFailure(call: Call<ProfileModel>, t: Throwable) {
                Log.e("MainActivityViewModel", "Error: ${t.message}")
            }
        })
    }
}

private fun <T> Call<T>?.enqueue(callback: Callback<ProfileModel>) {

}
