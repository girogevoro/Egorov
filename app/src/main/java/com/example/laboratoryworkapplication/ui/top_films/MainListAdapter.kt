package com.example.laboratoryworkapplication.ui.top_films

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.laboratoryworkapplication.R
import com.example.laboratoryworkapplication.databinding.FragmentTopFilmsItemBinding
import com.example.laboratoryworkapplication.domain.entity.FilmTop

class MainListAdapter(private val details: (idFilm: Int?) -> Unit) :
    PagingDataAdapter<FilmTop, FilmTopViewHolder>(FilmTopDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmTopViewHolder {
        return FilmTopViewHolder(
            FragmentTopFilmsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            details
        )
    }

    override fun onBindViewHolder(holder: FilmTopViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class FilmTopViewHolder(
    private val binding: FragmentTopFilmsItemBinding,
    private val details: (idFilm: Int?) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(filmTop: FilmTop?) {
        with(binding) {
            nameTextView.text = filmTop?.title
            typeTextView.text = binding.root.context.getString(
                R.string.top_film_type_tv,
                filmTop?.genres?.joinToString(SEPARATOR),
                filmTop?.year
            )
            ratingImageView.visibility = View.INVISIBLE
            bannerImageView.load(filmTop?.posterUrlPreview)
            root.setOnClickListener { details.invoke(filmTop?.id) }
        }
    }

    companion object {
        const val SEPARATOR = ", "
    }
}

private object FilmTopDiffItemCallback : DiffUtil.ItemCallback<FilmTop>() {

    override fun areItemsTheSame(oldItem: FilmTop, newItem: FilmTop): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FilmTop, newItem: FilmTop): Boolean {
        return oldItem.title == newItem.title && oldItem.posterUrlPreview == newItem.posterUrlPreview
    }
}