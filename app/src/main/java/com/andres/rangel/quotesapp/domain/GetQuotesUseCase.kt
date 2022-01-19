package com.andres.rangel.quotesapp.domain

import com.andres.rangel.quotesapp.data.QuoteRepository
import com.andres.rangel.quotesapp.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}