package com.example.laboratoryworkapplication.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.laboratoryworkapplication.data.toFilmTop
import com.example.laboratoryworkapplication.domain.entity.FilmTop
import retrofit2.HttpException

class FilmsTopPagingSource(private val apiService: ApiService) : PagingSource<Int, FilmTop>() {
    override fun getRefreshKey(state: PagingState<Int, FilmTop>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FilmTop> {
        try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val response = apiService.getFilmsTop(pageNumber)

            return if (response.isSuccessful) {

                val filmsTop = response.body()!!.films.map { it.toFilmTop() }
                val pageSizeMax = response.body()!!.pagesCount
                val nextPageNumber = if (pageNumber == pageSizeMax) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                LoadResult.Page(filmsTop, prevPageNumber, nextPageNumber)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    companion object {

        const val INITIAL_PAGE_NUMBER = 1
    }

}