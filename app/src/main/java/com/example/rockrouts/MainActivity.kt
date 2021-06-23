package com.example.rockrouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var routAdapter: routAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        routAdapter = routAdapter(mutableListOf())

        rvRoutList.adapter = routAdapter
        rvRoutList.layoutManager = LinearLayoutManager(this)

        btnAddRout.setOnClickListener {
            val routName = etRoutName.text.toString()
            val Grade = etGrade.text.toString()
            val Setter = etSetter.text.toString()
            if (routName.isNotEmpty() && Grade.isNotEmpty() && Setter.isNotEmpty()) {
                val rout = rout(routName, Grade, Setter)
                routAdapter.addRout(rout)
                etRoutName.text.clear()
                etGrade.text.clear()
                etSetter.text.clear()
            }
        }
    }
}