package com.example.interaksiactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.interaksiactivity.databinding.ActivityTambahBinding

class TambahActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    private lateinit var binding : ActivityTambahBinding

//     var rg_gender = binding.rgGender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTambahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTambahData.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == binding.btnTambahData){
            if (binding.rgGender.checkedRadioButtonId != 0){
                var value=""
                when(binding.rgGender.checkedRadioButtonId){
                    R.id.laki_laki -> value= "Laki-laki"
                    R.id.perempuan -> value= "Perempuan"
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}