package com.example.funnyjokes.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.funnyjokes.databinding.ActivityMainBinding
import com.example.funnyjokes.JavaApplication
import com.example.funnyjokes.di.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy{
        (application as JavaApplication).component
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[JokeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observe()
        binding.buttonLoadJoke.setOnClickListener {
            viewModel.loadJoke()
        }
    }
    private fun observe() {
        viewModel.state.observe(this) {
            binding.progressBar.visibility = View.INVISIBLE
            binding.buttonLoadJoke.isEnabled = true
            when (it) {
                is JokeState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.buttonLoadJoke.isEnabled = false
                }
                is JokeState.Info -> {
                    binding.textViewJoke.text =it.joke.setup
                }
            }
        }
    }
}
