package com.andres.rangel.quotesapp.domain

import com.andres.rangel.quotesapp.data.QuoteRepository
import com.andres.rangel.quotesapp.data.model.QuoteModel
import com.andres.rangel.quotesapp.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}