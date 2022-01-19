package com.andres.rangel.quotesapp.data

import com.andres.rangel.quotesapp.data.model.QuoteModel
import com.andres.rangel.quotesapp.data.model.QuoteProvider
import com.andres.rangel.quotesapp.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quoteService: QuoteService,
    private val quoteProvider: QuoteProvider
) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = quoteService.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}