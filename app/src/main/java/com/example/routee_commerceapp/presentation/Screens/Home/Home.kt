package com.example.routee_commerceapp.presentation.Screens.Home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.routee_commerceapp.constants.sliderList
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.ImageSliderWithIndicators
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.SearchBar
import com.example.routee_commerceapp.presentation.viewmodel.Home.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Home(modifier: Modifier = Modifier,
         viewModel: HomeViewModel = hiltViewModel()
       ) {
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item(){
                SearchBar()
                Spacer(modifier = Modifier.height(4.dp))
            }
            item {
                ImageSliderWithIndicators(images = sliderList[0])
            }

        }
    }


}

@Preview(showSystemUi = true)
@Composable
private fun shape() {
    Home()

}