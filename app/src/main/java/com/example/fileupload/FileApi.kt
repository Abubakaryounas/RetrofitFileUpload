package com.example.fileupload

import okhttp3.MultipartBody
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.Multipart
import retrofit2.http.Part

interface FileApi {

    @Multipart
    suspend fun uploadImage(
        @Part image:MultipartBody.Part

    )

    companion object{
        val instance by lazy {
            Retrofit.Builder()
                .baseUrl("http://192.168.122.255")
                .build()
                .create(FileApi::class.java)
        }
    }
}