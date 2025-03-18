package com.jdw.listview_second

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<ListViewModel>(
            ListViewModel("1"),
            ListViewModel("2"),
            ListViewModel("3"),
        )

        val adapter = ListViewAdapter(list)

        val rv = findViewById<RecyclerView>(R.id.rv)

        rv.adapter = adapter

        rv.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : ListViewAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, list[position].text, Toast.LENGTH_LONG).show()
            }
        }

    }
}