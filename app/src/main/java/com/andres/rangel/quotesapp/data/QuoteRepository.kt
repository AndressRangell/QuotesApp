package com.andres.rangel.quotesapp.data

import com.andres.rangel.quotesapp.data.model.QuoteModel
import com.andres.rangel.quotesapp.data.model.QuoteProvider
import com.andres.rangel.quotesapp.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}