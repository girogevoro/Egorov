package com.example.laboratoryworkapplication.ui.details_film

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import coil.load
import com.example.laboratoryworkapplication.R
import com.example.laboratoryworkapplication.databinding.FragmentDetailsFilmBinding
import com.example.laboratoryworkapplication.utils.ViewBindingFragment
import com.example.laboratoryworkapplication.utils.bundle.argument
import com.example.laboratoryworkapplication.utils.navigationPopBackStack
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFilmFragment :
    ViewBindingFragment<FragmentDetailsFilmBinding>(FragmentDetailsFilmBinding::inflate) {

    private val viewModel: DetailsFilmViewModel by viewModel()
    var filmId: Int by argument()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onLaunch(filmId)
        initLiveData()
        binding.topAppBar.setNavigationOnClickListener {
            onBack()
        }
    }

    override fun onBackPressed(): Boolean {
        onBack()
        return false
    }

    private fun onBack() {
        navigationPopBackStack()
    }

    private fun initLiveData() {
        viewModel.getLiveDataLoadState().observe(viewLifecycleOwner) {
            when (it) {
                is DetailsFilmState.LoadState.Success -> {
                    with(binding) {
                        progress.isVisible = false
                        bannerImageView.load(it.data.posterUrl){placeholder(R.drawable.ic_placeholder_24)}
                        titleTextView.text = it.data.title
                        descriptionTextView.text = it.data.description
                        genresTextView.text = getString(
                            R.string.details_film_genres_tv,
                            it.data.genres.joinToString(SEPARATOR)
                        )
                        countriesTextView.text = getString(
                            R.string.details_film_countries,
                            it.data.countries.joinToString(SEPARATOR)
                        )
                        yearTextView.text = it.data.year
                    }
                }

                is DetailsFilmState.LoadState.Error -> {
                    binding.progress.isVisible = false
                    Snackbar.make(
                        requireContext(),
                        binding.root,
                        resources.getText(R.string.Information_there_is_no_connection),
                        Snackbar.LENGTH_INDEFINITE
                    ).apply {
                        setAction(getString(R.string.retry)) { viewModel.onLaunch(filmId); dismiss() }
                    }.show()
                }

                is DetailsFilmState.LoadState.Loading -> {
                    binding.progress.isVisible = true
                }
            }
        }
    }

    companion object {
        const val SEPARATOR = ", "

        fun newInstance(filmId: Int) = DetailsFilmFragment().apply {
            //делегат
            this.filmId = filmId
        }
    }


}