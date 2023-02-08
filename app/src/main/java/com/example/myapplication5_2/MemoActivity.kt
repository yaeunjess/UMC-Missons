package com.example.myapplication5_2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication5_2.databinding.ActivityMemoBinding

class MemoActivity :AppCompatActivity() {

    lateinit var binding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply{
                putExtra("memo", binding.edtMemo.text.toString())
            }
            setResult(RESULT_OK, intent)
            if(!isFinishing) finish()
        }
    }
}