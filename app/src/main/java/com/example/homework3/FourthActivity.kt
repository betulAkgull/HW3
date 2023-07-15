package com.example.homework3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.homework3.databinding.ActivityFourthBinding
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val info = intent.getParcelableExtra("info") as Info?

        with(binding) {
            tvNamesurname.text = info?.user?.nameSurname
            tvAddress.text = info?.user?.address
            tvEmail.text = info?.user?.email
            tvUniversity.text = info?.university
            tvMajor.text = info?.major
            tvGpa.text = info?.gpa.toString()

            btnSubmit.setOnClickListener {
                btnSubmit()
            }


            onBackPressedDispatcher.addCallback(this@FourthActivity,
                object : OnBackPressedCallback(true) {
                    var count = 0
                    override fun handleOnBackPressed() {
                        count++
                        if (count == 2) {
                            btnSubmit()
                        }
                        Toast.makeText(
                            this@FourthActivity,
                            R.string.tap_again_to_go_homepage,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                })

        }

    }

    fun btnSubmit() {

        val intentt = Intent(this@FourthActivity, MainActivity::class.java)
        intentt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentt)

    }
}