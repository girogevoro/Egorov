package com.example.laboratoryworkapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laboratoryworkapplication.ui.top_films.TopFilmsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTopFilmsScreen(savedInstanceState)
    }

    private fun initTopFilmsScreen(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.container,
                    TopFilmsFragment.newInstance(),
                    TopFilmsFragment.TAG_MAIN_MENU_FRAGMENT
                )
                .commitAllowingStateLoss()
    }
}