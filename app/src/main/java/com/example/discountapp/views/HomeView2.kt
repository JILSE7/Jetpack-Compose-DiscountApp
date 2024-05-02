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
import com.example.discountapp.viewModel.CalculateViewModel1
import com.example.discountapp.viewModel.CalculateViewModel2
import com.example.discountapp.viewModel.FieldType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  HomeView2(viewModel2: CalculateViewModel2) {
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
        Container2(it, viewModel2)
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Container2 (paddingValues: PaddingValues, viewModel2: CalculateViewModel2){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        /* verticalArrangement = Arrangement.Center,*/
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        TwoCards(
            title1 = "Total",
            title2 = "Discount",
            number1 = viewModel2.total,
            number2 = viewModel2.priceWDiscount
        )

        MainTextField(label = "Price", value = viewModel2.price, onValueChange = {viewModel2.handleChange(FieldType.PRICE, it.toDouble())})

        SpaceHeight(8.dp)

        MainTextField(label = "Discount", value = viewModel2.discount, onValueChange = {viewModel2.handleChange(FieldType.DISCOUNT, it.toDouble())})

        SpaceHeight(24.dp)

        MainButton(text = "Generate Discount") {
            if (viewModel2.price == 0.0 || viewModel2.discount == 0.0) {
                viewModel2.handleAlert(true)
            }
            viewModel2.startCalculate()
            /*viewModel2._price1 = 0*/
            /*var result = viewModel2.calculate(price, discount)

            showAlert = result.second.second

            if (!showAlert) {
                priceWDiscount = result.first
                total = result.second.first
                }*/
            }
        SpaceWidth(24.dp)

        MainButton(text = "Clear", color = Color.Red) {
              viewModel2.handleReset()
        }

        if (viewModel2.showAlert) {
            Alert(
                title = "Alert",
                message = "Price and discount should not be zero",
                confirmText = "Confirm",
                onConfirm = {viewModel2.handleAlert(false) }){}
        }

    }
}