package com.example.discountapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.discountapp.model.DiscountState
import com.example.discountapp.utils.getDiscount
import com.example.discountapp.utils.getPrice

class CalculateViewModel3: ViewModel() {

    var state by mutableStateOf(DiscountState())
    private set

    fun handleChange(field: FieldType, value: Double) {
        state = when(field) {
            FieldType.PRICE -> state.copy(price = value)
            FieldType.DISCOUNT -> state.copy(discount = value)
        }
    }

    fun handlePrice(value: Double) {
        state = state.copy(
            price = value
        )
    }

    fun handleDiscount(value: Double) {
        state = state.copy(
            discount = value
        )
    }

    fun handleReset() {
        state = state.copy(
            price = 0.0,
            discount = 0.0,
            total = 0.0,
            priceWDiscount = 0.0
        )
    }

    fun handleAlert(isShow: Boolean) {
        state = state.copy(
            showAlert = isShow
        )
    }


    fun startCalculate(){
        val price = state.price
        val discount = state.discount

        val total = getPrice(price, discount)
        val priceWDiscount = getDiscount(price, discount)

        state = state.copy(
            total = priceWDiscount,
            priceWDiscount = total
        )
    }
}