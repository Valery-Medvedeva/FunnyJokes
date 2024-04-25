package com.example.funnyjokes.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.funnyjokes.JavaApplication
import com.example.funnyjokes.databinding.ActivityFavoriteBinding
import com.example.funnyjokes.di.ViewModelFactory
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var jokeAdapter: JokeAdapter

    private val binding by lazy {
        ActivityFavoriteBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as JavaApplication).component
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[FavoriteViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        viewModel.getJokeList()
    }

    private fun setupRecyclerView() {
        val rv = binding.rv
        jokeAdapter=JokeAdapter()
        rv.adapter = jokeAdapter
    }

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, FavoriteActivity::class.java)
        }
    }
}