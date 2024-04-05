package com.cricoo.selling_gadgets


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonLogout: Button = findViewById(R.id.buttonLogout)
        buttonLogout.setOnClickListener {
            logout()
        }
    }

    // Обробник кліків для кнопки
    fun openLaptopListActivity(view: View) {
        val intent = Intent(this, LaptopListActivity::class.java)
        startActivity(intent)
    }
    private fun logout() {
        // Очистити дані авторизації та перейти на сторінку авторизації
        // Наприклад, ви можете використовувати SharedPreferences або інші механізми зберігання даних
        // Очистіть будь-які дані аутентифікації, які зберігаються в SharedPreferences
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()

        // Перехід на сторінку авторизації
        val intent = Intent(this, LoginActivity::class.java)
        // Завершити поточну активність і всі інші активності на стеку зверху
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}

