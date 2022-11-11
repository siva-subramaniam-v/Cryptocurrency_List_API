package com.example.cryptocurrencylistapi.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptocurrencylistapi.network.CryptoDetails
import com.example.cryptocurrencylistapi.R
import com.example.cryptocurrencylistapi.network.CryptoDetailsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _cryptoList = MutableLiveData<List<CryptoDetails>>()

    val cryptoList: LiveData<List<CryptoDetails>>
        get() = _cryptoList

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getCryptoDetails()
    }

    private fun getCryptoDetails() {
        coroutineScope.launch {
            val listResult = CryptoDetailsApi.retrofitService.getCryptoDetailsAsync()
            try {
                if (listResult.isNotEmpty()) {
                    _cryptoList.value = listResult
                }
            } catch (t: Throwable) {
                _status.value = "Failure: ${t.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}