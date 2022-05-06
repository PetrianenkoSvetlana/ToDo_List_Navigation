package com.example.todo_list.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todo_list.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ViewingContent : Fragment(R.layout.viewing_content) {

    private val argument: ViewingContentArgs by navArgs()


    private lateinit var back: Button
    private lateinit var argTitle: TextView
    private lateinit var argExtraDescription: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back = view.findViewById(R.id.Back)
        argTitle = view.findViewById(R.id.titleViewing)
        argExtraDescription = view.findViewById(R.id.extraDescriptionViewing)

        initView()
    }

    private fun initView() {
        back.setOnClickListener {
            findNavController().popBackStack()
        }

        argTitle.text = argument.title
        argExtraDescription.text = argument.extraDescription
    }
}