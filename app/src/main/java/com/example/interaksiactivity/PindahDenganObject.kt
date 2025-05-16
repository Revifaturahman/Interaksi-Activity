package com.example.interaksiactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.interaksiactivity.databinding.ActivityPindahDenganObjectBinding

class PindahDenganObject : AppCompatActivity() {

    companion object {
        const val person = "person"
    }

    private lateinit var binding : ActivityPindahDenganObjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPindahDenganObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>(person) as Person
        val text = "Nama: ${person.name.toString()}"+
                "\nAge: ${person.age.toString()}"+
                "\nEmail: ${person.email.toString()}"+
                "\nKota: ${person.city.toString()}"
        binding.txtPindahObject.text = text
    }
}