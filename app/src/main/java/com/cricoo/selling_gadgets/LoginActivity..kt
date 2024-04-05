package com.cricoo.selling_gadgets

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Отримати збережені дані про користувача з SharedPreferences
            val savedUsername = sharedPreferences.getString("username", "")
            val savedPassword = sharedPreferences.getString("password", "")

            // Перевірити, чи введені дані співпадають зі збереженими
            if (username == savedUsername && password == savedPassword) {
                // Якщо співпадають, виконати авторизацію
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                // Перехід на сторінку Меню
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish() // Завершити поточну активність, щоб користувач не міг повернутися на екран авторизації за допомогою кнопки "Назад"
            } else {
                // Якщо дані не співпадають, вивести повідомлення про помилку
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }


    // Функція для переходу на сторінку реєстрації
    fun goToRegisterPage(view: android.view.View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}
