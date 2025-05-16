package com.example.interaksiactivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.interaksiactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{

//    Tanggal Pengerjaan: 16-05-2025
//    Nim: 10122001
//    Nama: Revi Faturahman
//    Kelas: PA-3

    private lateinit var binding: ActivityMainBinding
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == TambahActivity.RESULT_CODE && result.data != null) {
            val selectedValue = result.data?.getStringExtra(TambahActivity.EXTRA_SELECTED_VALUE)
            binding.result.text = "Jenis Kelamin: $selectedValue"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPindah.setOnClickListener(this)
        binding.btnPindahdata.setOnClickListener(this)
        binding.btnPindahobject.setOnClickListener(this)
        binding.btnDial.setOnClickListener(this)
        binding.btnAnotherapps.setOnClickListener(this)
        binding.btnTambahData.setOnClickListener(this)
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
            binding.btnPindahobject -> {
                val person = Person(
                    "Revi Faturahman",
                    22,
                    "revifaturahman05@gmail.com",
                    "Bandung"
                )

                val intent_object = Intent(this, PindahDenganObject::class.java)
                intent_object.putExtra("person", person)
                startActivity(intent_object)
            }
            binding.btnDial -> {
                val number = "085659431655"
                val intent_dial = Intent(Intent.ACTION_DIAL, Uri.parse("tel: ${number}"))
                startActivity(intent_dial)
            }
            binding.btnAnotherapps -> {
                val intent_anotherapp = Intent(Intent.ACTION_MAIN)
                intent_anotherapp.setPackage("com.google.android.youtube")
                startActivity(intent_anotherapp)
            }
            binding.btnTambahData -> {
                val forResult = Intent(this, TambahActivity::class.java)
                resultLauncher.launch(forResult)
            }
        }
    }
}