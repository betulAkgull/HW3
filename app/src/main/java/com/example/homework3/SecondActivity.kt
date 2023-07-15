package com.example.homework3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameSurname = intent.getStringExtra("namesurname")

        with(binding) {
            tvNamesurname.text = nameSurname.toString()
            btnSubmit.setOnClickListener {
                if (!etAddress.text.isNullOrEmpty() && !etEmail.text.isNullOrEmpty()) {
                    val user = User(
                        nameSurname.toString(),
                        etEmail.text.toString(),
                        etAddress.text.toString()
                    )
                    val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@SecondActivity,
                        getString(R.string.fill_required_field),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }
}