package com.example.discountapp.views

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.discountapp.components.Alert
import com.example.discountapp.components.MainButton
import com.example.discountapp.components.MainTextField
import com.example.discountapp.components.SpaceHeight
import com.example.discountapp.components.SpaceWidth
import com.example.discountapp.components.TwoCards
import com.example.discountapp.utils.getDiscount
import com.example.discountapp.utils.getPrice

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "App Descuentos ") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        Container(it)
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Container(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
       /* verticalArrangement = Arrangement.Center,*/
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var price by remember {
            mutableDoubleStateOf(0.0)
        }

        var discount by remember {
            mutableDoubleStateOf(0.0)
        }

        var priceWDiscount by remember {
            mutableDoubleStateOf(0.0)
        }

        var total by remember {
            mutableDoubleStateOf(0.0)
        }

        var showAlert by remember {
            mutableStateOf(false)
        }
        
        TwoCards(
            title1 = "Total",
            title2 = "Discount",
            number1 = total,
            number2 = priceWDiscount
        )

        MainTextField(label = "Price", value = price, onValueChange = {price = it.toDouble()})

        SpaceHeight(8.dp)

        MainTextField(label = "Discount", value = discount, onValueChange = {discount = it.toDouble()})

        SpaceHeight(24.dp)

        MainButton(text = "Generate Discount") {
            if (price == 0.0 || discount == 0.0) {
                showAlert = true
                return@MainButton
            }

            priceWDiscount = getPrice(price, discount)
            total = getDiscount(price, discount)
        }
        SpaceWidth(24.dp)

        MainButton(text = "Clear", color = Color.Red) {
            price = 0.0
            discount = 0.0
            total = 0.0
            priceWDiscount = 0.0
        }
        
        if (showAlert) {
            Alert(
                title = "Alert",
                message = "Price and discount should not be zero",
                confirmText = "Confirm",
                onConfirm = { showAlert = false }){}
        }

    }
}