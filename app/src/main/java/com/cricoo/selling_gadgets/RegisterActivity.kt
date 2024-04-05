package com.cricoo.selling_gadgets

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        val firstNameEditText = findViewById<EditText>(R.id.firstNameEditText)
        val lastNameEditText = findViewById<EditText>(R.id.lastNameEditText)
        val birthDateEditText = findViewById<EditText>(R.id.birthDateEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val registerUsernameEditText = findViewById<EditText>(R.id.registerUsernameEditText)
        val registerPasswordEditText = findViewById<EditText>(R.id.registerPasswordEditText)
        val confirmPasswordEditText = findViewById<EditText>(R.id.confirmPasswordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val birthDate = birthDateEditText.text.toString()
            val email = emailEditText.text.toString()
            val username = registerUsernameEditText.text.toString()
            val password = registerPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            // Виконати перевірку реєстрації тут

            // Приклад збереження введених даних в SharedPreferences
            with(sharedPreferences.edit()) {
                putString("firstName", firstName)
                putString("lastName", lastName)
                putString("birthDate", birthDate)
                putString("email", email)
                putString("username", username)
                putString("password", password)
                apply()
            }

            // Повернутися на екран авторизації після реєстрації
            finish()
        }
    }
}
