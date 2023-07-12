package com.example.homework3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework3.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val info = intent.getParcelableExtra("info") as Info?

        with(binding){
            tvNamesurname.text = info?.user?.nameSurname
            tvAddress.text = info?.user?.address
            tvEmail.text = info?.user?.email
            tvUniversity.text = info?.university
            tvMajor.text = info?.major
            tvGpa.text = info?.gpa.toString()

            btnSubmit.setOnClickListener {
                startActivity(Intent(this@FourthActivity,MainActivity::class.java))
            }
        }

    }
}