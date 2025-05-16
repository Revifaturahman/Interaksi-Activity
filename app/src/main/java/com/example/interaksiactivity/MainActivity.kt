package com.example.interaksiactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.interaksiactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPindah.setOnClickListener(this)
        binding.btnPindahdata.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when(v){
            binding.btnPindah -> {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
            binding.btnPindahdata -> {
                val intent_data = Intent(this, PindahDenganData::class.java)
                intent_data.putExtra("name", "Revi Faturahman")
                intent_data.putExtra("age", 22)
                startActivity(intent_data)
            }
        }
    }
}