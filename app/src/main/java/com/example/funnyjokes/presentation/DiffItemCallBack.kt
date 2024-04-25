package com.example.funnyjokes.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.funnyjokes.domain.Joke

class DiffItemCallBack : DiffUtil.ItemCallback<Joke>() {
    override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem.id == newItem.id
               && oldItem.setup == newItem.setup
               && oldItem.punchline == newItem.punchline
    }
}