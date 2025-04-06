package com.example.routee_commerceapp.presentation.Screens.Home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.routee_commerceapp.constants.Destination
import com.example.routee_commerceapp.constants.sliderList
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel
import com.example.routee_commerceapp.presentation.Screens.Categories.CategoriesScreen
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.Advert
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.BottomNavigationBar
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.CategoriesSection
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.ImageSliderWithIndicators
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.MobileProductsSection
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.SearchBar
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.WomenProductsSection
import com.example.routee_commerceapp.presentation.viewmodel.Home.HomeViewModel
@Composable
fun HomeUi(viewModel: HomeViewModel = hiltViewModel() , navHostController: NavHostController , productList: List<ProductModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding()
    ) {
        item {
            SearchBar()
            Spacer(modifier = Modifier.height(4.dp))
        }
        item {
            ImageSliderWithIndicators(images = sliderList[0])
            Spacer(modifier = Modifier.height(6.dp))
        }
        item {
            CategoriesSection()
            Spacer(modifier = Modifier.height(6.dp))
        }
        item {
            MobileProductsSection(
                navHostController = navHostController,
                productList = productList
            )
            Spacer(modifier = Modifier.height(6.dp))
        }
        item {
            Advert()
        }
        item {
            WomenProductsSection(navHostController = navHostController , productList = productList)
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}


