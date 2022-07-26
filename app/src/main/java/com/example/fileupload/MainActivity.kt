package com.example.fileupload

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fileupload.ui.theme.FileUploadTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FileUploadTheme {

                val viewModel = viewModel<FileViewModel>()
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        val file = File(cacheDir, "img.png")
                        file.createNewFile()
                        file.outputStream().use {
                            assets.open("img.png").copyTo(it)
                        }
                        viewModel.uploadImage(file)
                    })
                    {
                        Text(text = "Upload Image")
                    }
                }

            }
        }

    }
}



