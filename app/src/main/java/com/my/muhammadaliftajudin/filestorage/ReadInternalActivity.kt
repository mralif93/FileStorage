package com.my.muhammadaliftajudin.filestorage

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.muhammadaliftajudin.filestorage.databinding.ActivityReadInternalBinding
import java.io.BufferedReader

class ReadInternalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadInternalBinding
    val fileName = "testFile.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityReadInternalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fileContent = readFileInternalStorage(fileName, this)
        binding.internalMessageTextView.text = fileContent
    }

    private fun readFileInternalStorage(fileName: String, context: Context): String {
        var stringToReturn = ""

        try {
            val inputStream = context.openFileInput(fileName)
            if (inputStream != null) {
                stringToReturn = inputStream.bufferedReader().use(BufferedReader::readText)
            }
        } catch (e:Exception) {
            print(e.message)
        }

        return stringToReturn
    }
}