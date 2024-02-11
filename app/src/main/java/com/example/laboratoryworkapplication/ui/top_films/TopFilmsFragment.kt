package com.example.laboratoryworkapplication.ui.top_films

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratoryworkapplication.R
import com.example.laboratoryworkapplication.databinding.FragmentTopFilmsBinding
import com.example.laboratoryworkapplication.utils.ViewBindingFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopFilmsFragment :
    ViewBindingFragment<FragmentTopFilmsBinding>(FragmentTopFilmsBinding::inflate) {

    private val viewModel: TopFilmsViewModel by viewModel()
    private val mainListAdapter by lazy { MainListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTopAppBar()
        intiTopFilmsRv()
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


    private fun intiTopFilmsRv() {
        binding.topFilmsRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mainListAdapter
        }

        lifecycleScope.launch {
            viewModel.listData.collect {
                mainListAdapter.submitData(it)
            }
        }
    }

    companion object {
        const val TAG_MAIN_MENU_FRAGMENT = "TAG_MAIN_MENU_FRAGMENT"

        fun newInstance() = TopFilmsFragment()
    }
}