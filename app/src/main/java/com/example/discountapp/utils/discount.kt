package com.example.discountapp.utils

fun getPrice(price: Double, discount: Double): Double{
    val result = price  - getDiscount(price, discount)

    return kotlin.math.round(result * 100) / 100.0
}

fun getDiscount(price: Double, discount: Double): Double {
    val result = price * (1 - discount / 100)
    return kotlin.math.round(result * 100) / 100.0
}