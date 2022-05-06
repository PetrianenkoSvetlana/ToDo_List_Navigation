package com.example.todo_list.easy

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.Item
import com.example.todo_list.R
import com.example.todo_list.screens.ContentMainDirections

class EasyAdapter : RecyclerView.Adapter<EasyAdapter.EasyViewHolder>() {

    private val items: MutableList<Item> = mutableListOf()
    private lateinit var recyclerView: RecyclerView

    fun setItems(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EasyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_string, parent, false)
        return EasyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EasyViewHolder, position: Int) {
        val check = holder.itemView.findViewById<CheckBox>(R.id.Check)
        check.setOnCheckedChangeListener { buttonView, isChecked ->
            if (!isChecked)
                buttonView.paintFlags = buttonView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            else
                buttonView.paintFlags = buttonView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            items[position].achievement = isChecked
        }

        check.text = items[position].title
        check.isChecked = items[position].achievement

        val itemView = holder.itemView.findViewById<ConstraintLayout>(R.id.item_string)

        itemView.setOnClickListener {
            view -> Navigation.findNavController(view).navigate(
                ContentMainDirections.actionContentMainToViewingContent(items[position].title, items[position].extraDescription)
            )
        }
    }

    override fun getItemCount(): Int = items.size

    class EasyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}