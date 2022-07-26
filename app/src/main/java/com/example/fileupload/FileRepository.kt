package com.example.fileupload

import okhttp3.MultipartBody
import retrofit2.HttpException
import retrofit2.http.POST
import java.io.File
import java.io.IOException

class FileRepository {
    suspend fun uploadImage(file:File) :Boolean{
        return try {
            FileApi.instance.uploadImage(
                image = MultipartBody.Part
                    .createFormData(
                        "image",
                        file.name)
            )
            true
        }
        catch (e:IOException){
            e.printStackTrace()
            false
        }catch (e:HttpException){
            e.printStackTrace()
            false
        }
    }
}