package com.example.interaksiactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.interaksiactivity.databinding.ActivityPindahDenganDataBinding


class PindahDenganData : AppCompatActivity() {

    companion object{
        const val name = "name"
        const val age = "age"
    }

    private lateinit var binding: ActivityPindahDenganDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPindahDenganDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(name)
        val age = intent.getIntExtra(age, 0)
        val text = "nama: $name dan umur: $age"
        binding.txtPindahData.text = text

    }
}