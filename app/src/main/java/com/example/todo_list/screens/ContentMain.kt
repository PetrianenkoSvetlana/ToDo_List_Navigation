package com.example.todo_list.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.Item
import com.example.todo_list.MainActivity
import com.example.todo_list.R
import com.example.todo_list.easy.EasyAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ContentMain : Fragment(R.layout.content_main) {

    private val argument: ContentMainArgs by navArgs()

    private lateinit var easyAdapter: EasyAdapter
    private lateinit var add: Button
    private lateinit var recycler: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number = MainActivity.list.count()
        if (argument.title != "По умолчанию") {
            val item = Item(argument.title, argument.extraDescription, false)
            MainActivity.list.add(number, item)
        }
        easyAdapter = EasyAdapter()
        add = view.findViewById(R.id.AddItem)
        recycler = view.findViewById(R.id.main_recycler)

        initView()
    }

    private fun initView() {
        recycler.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = easyAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        easyAdapter.setItems(MainActivity.list)

        add.setOnClickListener {
            findNavController().navigate(R.id.action_contentMain_to_addingContent)
        }
    }
}