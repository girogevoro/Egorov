package com.example.laboratoryworkapplication

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
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
        val portraitNew = isPortrait()
        val portraitOld = savedInstanceState?.getBoolean(IS_PORTRAIT) ?: portraitNew
        if (savedInstanceState == null || portraitNew != portraitOld) {

            if(portraitNew){
                navigationGoTo({ TopFilmsFragment.newInstance() }, R.id.container)
            }else{

            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        val portrait = isPortrait()
        outState.putBoolean(IS_PORTRAIT, portrait)
        super.onSaveInstanceState(outState, outPersistentState)
    }

    private fun isPortrait() =
        resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    companion object {
        private const val IS_PORTRAIT = "isPortrait"
    }
}