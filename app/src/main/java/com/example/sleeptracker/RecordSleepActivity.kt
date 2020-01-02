package com.example.sleeptracker

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_record_sleep.*
import kotlinx.android.synthetic.main.recyclerview_item.*

class RecordSleepActivity : AppCompatActivity() {
    private var quality : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_sleep)

        imageViewBack.setOnClickListener {
            finish()
        }

        imageView1.setOnClickListener {
            quality = 1
            textViewQuality.text = "Very Sad"
        }

        imageView2.setOnClickListener {
            quality = 2
            textViewQuality.text = "Sad"
        }

        imageView3.setOnClickListener {
            quality = 3
            textViewQuality.text = "Neutral"
        }

        imageView4.setOnClickListener {
            quality = 4
            textViewQuality.text = "Happy"
        }

        imageView5.setOnClickListener {
            quality = 5
            textViewQuality.text = "Very Happy"
        }

        buttonAdd.setOnClickListener {
            if (quality == 0) {
                Toast.makeText(applicationContext,
                    "Please indicate sleep quality",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener //Stop execution here
            }

            val intent = Intent()
            intent.putExtra(EXTRA_QUALITY, quality)
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }

    companion object {
        const val EXTRA_QUALITY = "com.example.sleeptracker.QUALITY"
    }
}
