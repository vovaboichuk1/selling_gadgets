package com.cricoo.selling_gadgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LaptopListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laptop_list)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val laptops = mutableListOf(
            Laptop("Laptop 1", "Details of Laptop 1"),
            Laptop("Laptop 2", "Details of Laptop 2"),
            Laptop("Laptop 3", "Details of Laptop 3"),
            // Додайте інші ноутбуки за потреби
        )

        val adapter = LaptopAdapter(laptops)
        recyclerView.adapter = adapter
    }
}
