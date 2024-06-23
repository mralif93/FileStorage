package com.my.muhammadaliftajudin.filestorage

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.my.muhammadaliftajudin.filestorage.databinding.ActivityWriteInternalBinding

class WriteInternalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWriteInternalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityWriteInternalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.internalSaveBtn.setOnClickListener {
            val fileName = binding.internalFileNameEditText.text.toString()
            val content = binding.internalContentEditText.text.toString()

            try {
                val fos = this.openFileOutput(fileName, Context.MODE_PRIVATE)
                fos.write(content.toByteArray())
                fos.flush()
                fos.close()
                Toast.makeText(this, "File written to Internal memory",
                    Toast.LENGTH_LONG).show()
            } catch (e:Exception) {
                print(e.message)
            }
        }
    }
}