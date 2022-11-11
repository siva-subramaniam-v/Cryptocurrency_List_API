package com.example.cryptocurrencylistapi.network

import com.squareup.moshi.Json

data class CryptoDetails(
    @Json(name="market_cap_rank")var rank: Long,
    @Json(name="image")var imgSrcUrl: String,
    @Json(name="symbol")var ticker: String,
    @Json(name="current_price")var currentPrice: Double,
    @Json(name="price_change_percentage_24h")var percentageChange: Double,
    @Json(name="market_cap")var marketCap: Long
)