package com.example.discountapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.discountapp.utils.getDiscount
import com.example.discountapp.utils.getPrice

enum class FieldType {
    PRICE,
    DISCOUNT
}

class CalculateViewModel2: ViewModel() {

    var price by mutableDoubleStateOf(0.0)
        private  set


    var discount by mutableDoubleStateOf(0.0)
        private set

    var priceWDiscount by mutableDoubleStateOf(0.0)
        private set

    var total by mutableDoubleStateOf(0.0)
        private  set

    var showAlert by mutableStateOf(false)
        private set

    fun handlePrice(value: Double) {
        price = value
    }

    fun handleDiscount(value: Double) {
        discount = value
    }

    fun handleReset() {
        price = 0.0
        discount = 0.0
        total = 0.0
        priceWDiscount = 0.0
    }

    fun handleAlert(isShow: Boolean) {
        showAlert = isShow
    }

    fun handleChange(field: FieldType, value: Double) {
        when(field) {
            FieldType.DISCOUNT -> discount = value
            FieldType.PRICE -> price = value
        }
    }

    fun startCalculate(){
        total = getPrice(price, discount)
        priceWDiscount = getDiscount(price, discount)
    }
}