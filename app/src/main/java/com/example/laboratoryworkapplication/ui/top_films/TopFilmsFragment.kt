package com.example.laboratoryworkapplication.ui.top_films

import android.os.Bundle
import android.view.View
import com.example.laboratoryworkapplication.R
import com.example.laboratoryworkapplication.databinding.FragmentTopFilmsBinding
import com.example.laboratoryworkapplication.utils.ViewBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopFilmsFragment :
    ViewBindingFragment<FragmentTopFilmsBinding>(FragmentTopFilmsBinding::inflate) {

    private val viewModel: TopFilmsViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTopAppBar()
    }

    private fun initTopAppBar() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                   //todo
                    true
                }

                else -> false
            }
        }
    }


    companion object {
        const val TAG_MAIN_MENU_FRAGMENT = "TAG_MAIN_MENU_FRAGMENT"

        fun newInstance() = TopFilmsFragment()
    }
}