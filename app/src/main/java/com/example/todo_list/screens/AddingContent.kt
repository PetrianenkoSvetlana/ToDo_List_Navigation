package com.example.todo_list.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todo_list.R

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddingContent : Fragment(R.layout.adding_content) {

    private lateinit var add: Button
    private lateinit var title: TextView
    private lateinit var extraDescription: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add = view.findViewById(R.id.Add)
        title = view.findViewById(R.id.titleInputAddingText)
        extraDescription = view.findViewById(R.id.extraDescriptionInputAddingText)

        addItem()
    }

    private fun addItem() {
        add.setOnClickListener {
            findNavController().navigate(
                AddingContentDirections.actionAddingContentToContentMain(
                    title.text.toString(), extraDescription.text.toString()
                )
            )
            findNavController().popBackStack(0, true)
        }
    }
}