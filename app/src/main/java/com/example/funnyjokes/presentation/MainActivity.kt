package com.example.funnyjokes.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.funnyjokes.databinding.ActivityMainBinding
import com.example.funnyjokes.JavaApplication
import com.example.funnyjokes.di.ViewModelFactory
import com.example.funnyjokes.domain.Joke
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as JavaApplication).component
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private lateinit var joke: Joke

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observe()
        setOnClickListeners()
    }

    private fun observe() {
        viewModel.state.observe(this) {
            binding.progressBar.visibility = View.INVISIBLE
            binding.buttonLoadJoke.isEnabled = true
            when (it) {
                is JokeState.Error -> {
                    Toast.makeText(
                        this,
                        "check your internet connection",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is JokeState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.buttonLoadJoke.isEnabled = false
                }

                is JokeState.Info -> {
                    joke = it.joke
                    binding.textViewJoke.text = it.joke.setup
                }
            }
        }
    }

    fun setOnClickListeners(){
        binding.buttonLoadJoke.setOnClickListener {
            viewModel.loadJoke()
        }
        binding.textViewJoke.setOnClickListener {
            if (!binding.textViewJoke.text.isNullOrBlank()) {
                binding.textViewJoke.text = joke.toString()
            }
        }
        binding.buttonFavorite.setOnClickListener {
            val intent=FavoriteActivity.newIntent(this)
            startActivity(intent)
        }
        binding.imageViewHeartEmpty.setOnClickListener {
            viewModel.addJokeToDb(joke)
        }
    }
}
