package com.andres.rangel.quotesapp.domain

import com.andres.rangel.quotesapp.data.QuoteRepository
import com.andres.rangel.quotesapp.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}