package com.jdw.listview_second

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<String>(
            "1",
            "2",
            "3",
        )

        val adapter = ListViewAdapter(list)

        val listview = findViewById<ListView>(R.id.mainListview)

        listview.adapter = adapter

        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, list[position], Toast.LENGTH_LONG).show()
        }

    }
}