package com.example.myapp2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textViewDetails: TextView = findViewById(R.id.textViewDetails)

        val name = intent.getStringExtra("NAME")
        val password = intent.getStringExtra("PASSWORD")
        val age = intent.getIntExtra("AGE", 0)
        val gender = intent.getStringExtra("GENDER")
        val hobbies = intent.getStringArrayListExtra("HOBBIES")

        val details = """
            Name: $name
            Password: $password
            Age: $age
            Gender: $gender
            Hobbies: ${hobbies?.joinToString(", ")}
        """.trimIndent()

        textViewDetails.text = details
    }
}
