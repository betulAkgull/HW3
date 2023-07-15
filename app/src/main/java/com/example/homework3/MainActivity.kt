package com.example.homework3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.homework3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnSubmit.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                if (!etNameSurname.text.isNullOrEmpty()) {
                    intent.putExtra("namesurname", etNameSurname.text.toString())
                    startActivity(intent)
                } else {
                    etNameSurname.requestFocus()
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.enter_your_name),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }



        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                System.exit(0)
            }

        })
    }


}