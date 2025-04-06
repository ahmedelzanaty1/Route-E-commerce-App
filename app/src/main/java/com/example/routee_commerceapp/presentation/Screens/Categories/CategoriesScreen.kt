package com.example.routee_commerceapp.presentation.Screens.Categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel
import com.example.routee_commerceapp.presentation.Screens.Categories.Componant.CategoriesItem
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.ProductCard
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.SearchBar
import com.example.routee_commerceapp.presentation.viewmodel.CategoryViewModel.CategoriesViewModel


@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: CategoriesViewModel = hiltViewModel(),
    productList: List<ProductModel>,
    navHostController: NavHostController

) {
    val categoriesState = viewModel.categories.collectAsState()
    val selectedCategory = viewModel.selectedCategory
    val productsState = viewModel.productsForSelected.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        // Add Search Bar
        item {
            SearchBar()
        }

        item {
            when (val categoryResult = categoriesState.value) {
                is Resource.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                is Resource.Success -> {
                    categoryResult.data?.let { categories ->
                        categories.forEach { category ->
                            CategoriesItem(
                                category = category,
                                isSelected = selectedCategory == category,
                                onCategorySelected = { selectedCategory ->
                                    viewModel.selectCategory(selectedCategory)
                                }
                            )
                        }
                    }
                }
                is Resource.Error -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "Error loading categories.")
                    }
                }
            }
        }

        item {
            when (val productResult = productsState.value) {
                is Resource.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                is Resource.Success -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.fillMaxWidth().heightIn(200.dp, 500.dp), // Adjusted height constraints
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(productResult.data ?: emptyList()) { product ->
                            ProductCard(
                                product = product,
                                navHostController = navHostController,
                                isFavorite = false,
                                onFavoriteClick = { /* منطق إضافة إلى المفضلة */ },
                                onAddToCartClick = { /* منطق إضافة إلى السلة */ },
                                onProductClick = {
                                        productId ->
                                    navHostController.navigate("product_details_screen/$productId")
                                }
                            )
                        }
                    }
                }
                is Resource.Error -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "Error loading products.")
                    }
                }
            }
        }
    }

}






