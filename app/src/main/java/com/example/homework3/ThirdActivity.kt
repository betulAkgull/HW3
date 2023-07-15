package com.example.homework3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework3.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra("user") as User?

        with(binding) {
            tvNamesurname.text = user?.nameSurname

            btnSubmit.setOnClickListener {
                if (!etUniversity.text.isNullOrEmpty() && !etMajor.text.isNullOrEmpty() && !etGpa.text.isNullOrEmpty()) {
                    val userInfo =
                        user?.let {
                            Info(
                                etUniversity.text.toString(),
                                etMajor.text.toString(),
                                etGpa.text.toString().toDouble(),
                                it
                            )
                        }

                    val intent = Intent(this@ThirdActivity, FourthActivity::class.java)
                    intent.putExtra("info", userInfo)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@ThirdActivity,
                        getString(R.string.fill_required_field),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }


        }

    }
}