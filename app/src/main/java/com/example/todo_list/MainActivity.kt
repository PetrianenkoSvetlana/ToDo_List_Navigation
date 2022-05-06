package com.example.todo_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        var list: MutableList<Item> = IntArray(10) {it}.map {
            Item("Задача ${it+1}", "Подробное описание ${it+1}", false)
        }.toMutableList()
    }
}