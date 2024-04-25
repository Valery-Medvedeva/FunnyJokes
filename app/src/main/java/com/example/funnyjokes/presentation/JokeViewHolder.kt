package com.example.funnyjokes.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyjokes.R

class JokeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val favJoke = view.findViewById<TextView>(R.id.textView_favouriteJoke)
}