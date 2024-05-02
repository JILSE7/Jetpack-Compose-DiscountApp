package com.example.discountapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.discountapp.ui.theme.DiscountAppTheme
import com.example.discountapp.viewModel.CalculateViewModel1
import com.example.discountapp.viewModel.CalculateViewModel2
import com.example.discountapp.viewModel.CalculateViewModel3
import com.example.discountapp.views.HomeView
import com.example.discountapp.views.HomeView2
import com.example.discountapp.views.HomeView3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CalculateViewModel1 by viewModels()
        val viewModel2: CalculateViewModel2 by viewModels()
        val viewModel3: CalculateViewModel3 by viewModels()
        setContent {
            DiscountAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeView3(viewModel3)
                    /*HomeView(viewModel)*/
                }
            }
        }
    }
}