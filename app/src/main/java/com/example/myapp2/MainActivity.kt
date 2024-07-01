package com.example.myapp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)
        val editTextAge: EditText = findViewById(R.id.editTextAge)
        val radioButtonMale: RadioButton = findViewById(R.id.radioButtonMale)
        val radioButtonFemale: RadioButton = findViewById(R.id.radioButtonFemale)
        val checkBoxReading: CheckBox = findViewById(R.id.checkBoxReading)
        val checkBoxTraveling: CheckBox = findViewById(R.id.checkBoxTraveling)
        val checkBoxCooking: CheckBox = findViewById(R.id.checkBoxCooking)
        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            val password = editTextPassword.text.toString()
            val age = editTextAge.text.toString().toInt()
            val gender = if (radioButtonMale.isChecked) "Male" else "Female"
            val hobbies = mutableListOf<String>()
            if (checkBoxReading.isChecked) hobbies.add("Reading")
            if (checkBoxTraveling.isChecked) hobbies.add("Traveling")
            if (checkBoxCooking.isChecked) hobbies.add("Cooking")

            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("NAME", name)
                putExtra("PASSWORD", password)
                putExtra("AGE", age)
                putExtra("GENDER", gender)
                putStringArrayListExtra("HOBBIES", ArrayList(hobbies))
            }
            startActivity(intent)
        }
    }
}
