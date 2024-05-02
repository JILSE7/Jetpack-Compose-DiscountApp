package com.example.discountapp.model

data class DiscountState(
    val price: Double = 0.0,
    val discount: Double = 0.0,
    val priceWDiscount: Double = 0.0,
    val total: Double = 0.0,
    val showAlert: Boolean = false
)
