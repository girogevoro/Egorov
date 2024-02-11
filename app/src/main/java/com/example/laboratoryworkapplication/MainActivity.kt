package com.example.laboratoryworkapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laboratoryworkapplication.ui.top_films.TopFilmsFragment
import com.example.laboratoryworkapplication.utils.navigationGoTo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTopFilmsScreen(savedInstanceState)
    }

    private fun initTopFilmsScreen(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            navigationGoTo { TopFilmsFragment.newInstance() }
        }
    }

}