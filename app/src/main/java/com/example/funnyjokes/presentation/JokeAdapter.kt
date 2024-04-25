package com.example.funnyjokes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.funnyjokes.R
import com.example.funnyjokes.domain.Joke

class JokeAdapter : ListAdapter<Joke, JokeViewHolder>(DiffItemCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke=getItem(position)
        holder.favJoke.text=joke.toString()
    }
}