package com.andres.rangel.quotesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.rangel.quotesapp.data.model.QuoteModel
import com.andres.rangel.quotesapp.data.model.QuoteProvider
import com.andres.rangel.quotesapp.domain.GetQuotesUseCase
import com.andres.rangel.quotesapp.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
            }
            isLoading.postValue(false)
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote != null){
            quoteModel.postValue(quote as QuoteModel?)
        }
        isLoading.postValue(false)
    }

}