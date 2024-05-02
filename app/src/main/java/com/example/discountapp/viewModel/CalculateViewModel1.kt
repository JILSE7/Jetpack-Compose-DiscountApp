package com.example.discountapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.discountapp.utils.getDiscount
import com.example.discountapp.utils.getPrice

class CalculateViewModel1: ViewModel() {


    fun calculate(price: Double, discount: Double): Pair<Double, Pair<Double, Boolean>> {
        var priceDiscount = 0.0
        var totalDiscount = 0.0
        var showAlert = false

        if (price == 0.0 || discount == 0.0) {
            showAlert = true
        }

        priceDiscount = getPrice(price, discount)
        totalDiscount = getDiscount(price, discount)

        return Pair(priceDiscount, Pair(totalDiscount, showAlert))
    }

    private fun getPriceVM(price: Double, discount: Double): Double{
        val result = price  - getDiscountVM(price, discount)

        return kotlin.math.round(result * 100) / 100.0
    }

    private fun getDiscountVM(price: Double, discount: Double): Double {
        val result = price * (1 - discount / 100)
        return kotlin.math.round(result * 100) / 100.0
    }
}