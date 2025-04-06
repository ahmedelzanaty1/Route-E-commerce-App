package com.example.routee_commerceapp.presentation.Screens.Home.Componant

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel
import com.example.routee_commerceapp.presentation.theme.darkblue
import com.example.routee_commerceapp.presentation.viewmodel.Home.HomeViewModel

@Composable
fun MobileProductsSection(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navHostController: NavHostController,
    productList: List<ProductModel>
) {
    val mobileProductsState = viewModel.mobileProductsState.collectAsState()

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Technology Products",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = darkblue,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        when (val result = mobileProductsState.value) {
            is Resource.Loading -> {
                Text(text = "Loading...", fontSize = 20.sp)
            }
            is Resource.Success -> {
                Log.e("TAG", "MobileProductsSection: ${result.data}")
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(result.data ?: emptyList()) { product ->
                        ProductCard(
                            product = product,
                            isFavorite = false,
                            navHostController = navHostController,
                            onFavoriteClick = { /* Handle favorite click */ },
                            onAddToCartClick = { /* Handle add to cart click */ },
                            onProductClick = { productId ->
                                navHostController.navigate("product_details_screen/$productId")
                            }
                        )
                    }
                }
            }
            is Resource.Error -> {
                Log.e("TAGError", "MobileProductsSection: ${result.message}")
                Text(text = result.message ?: "Error occurred", color = darkblue)
            }
        }
    }
}

