package com.example.tinkofflab2023.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.ActivityMainBinding
import com.example.tinkofflab2023.presentation.fragment.MainFragment
import com.example.tinkofflab2023.presentation.fragment.SearchFragment

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container,
                SearchFragment()
            )
            .commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}
