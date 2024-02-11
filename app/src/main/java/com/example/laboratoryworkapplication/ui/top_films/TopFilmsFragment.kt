package com.example.laboratoryworkapplication.ui.top_films

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratoryworkapplication.R
import com.example.laboratoryworkapplication.databinding.FragmentTopFilmsBinding
import com.example.laboratoryworkapplication.utils.ViewBindingFragment
import com.google.android.material.snackbar.Snackbar
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
            adapter = mainListAdapter.withLoadStateHeaderAndFooter(
                header = LoaderStateAdapter(mainListAdapter::retry),
                footer = LoaderStateAdapter(mainListAdapter::retry)
            )
        }

        lifecycleScope.launch {
            viewModel.listData.collect {
                mainListAdapter.submitData(it)
            }
        }

        mainListAdapter.addLoadStateListener { state ->
            with(binding) {
                topFilmsRv.isVisible = state.refresh != LoadState.Loading
                progress.isVisible = state.refresh == LoadState.Loading
                if (state.refresh is LoadState.Error) {
                    Snackbar.make(
                        requireContext(),
                        binding.root,
                        resources.getText(R.string.Information_there_is_no_connection),
                        Snackbar.LENGTH_INDEFINITE
                    ).apply {
                        setAction(getString(R.string.retry)) { mainListAdapter.retry(); dismiss() }
                    }.show()
                }

            }
        }

    }

    companion object {
        const val TAG_MAIN_MENU_FRAGMENT = "TAG_MAIN_MENU_FRAGMENT"

        fun newInstance() = TopFilmsFragment()
    }
}