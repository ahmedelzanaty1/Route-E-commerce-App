package com.example.routee_commerceapp.presentation.Screens.Details


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.presentation.viewmodel.Details.DetailsViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    navHostController: NavHostController,
    productId: String
) {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val detailsState = detailsViewModel.detailsState.collectAsState().value

    LaunchedEffect(productId) {
        detailsViewModel.getDetails(productId)
    }

    when (detailsState) {
        is Resource.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is Resource.Success -> {
            detailsState.data?.let { product ->
                LazyColumn(modifier = Modifier.fillMaxSize()) {

                    // Header
                    item {
                        TopAppBar(
                            title = { Text("Product Details") },
                            navigationIcon = {
                                IconButton(onClick = { navHostController.popBackStack() }) {
                                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                                }
                            },
                            actions = {
                                IconButton(onClick = { /* Handle add to favorites */ }) {
                                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                                }
                            }
                        )
                    }

                    item {
                        GlideImage(
                            model = product.data?.imageCover,
                            contentDescription = "Product Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                        )
                    }

                    item {
                        Text(
                            text = product.data?.title ?: "No Title",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    item {
                        Text(
                            text = "EGP ${product.data?.price}",
                            fontSize = 20.sp,
                            color = Color.Red,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    item {
                        Text(
                            text = "${product.data?.sold} Sold",
                            modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                        )
                    }

                    item {
                        Text(
                            text = "Rating: ${product.data?.ratingsAverage ?: "No Rating"} (${product.data?.ratingsQuantity ?: 0})",
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    item {
                        Text("Description", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp, top = 16.dp))
                        Text(product.data?.description ?: "No Description", modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp))
                    }

                    item {
                        Text("Size", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp, top = 16.dp))
                        Row(modifier = Modifier.padding(16.dp)) {
                            product.data?.quantity?.let {
                                for (size in listOf(38, 39, 40, 41, 42)) {
                                    Button(onClick = { /* select size */ }, modifier = Modifier.padding(4.dp)) {
                                        Text(size.toString())
                                    }
                                }
                            }
                        }
                    }

                    item {
                        Text("Color", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp, top = 16.dp))
                        Row(modifier = Modifier.padding(16.dp)) {
                            listOf(Color.DarkGray, Color.Red, Color.Green, Color.Blue).forEach { color ->
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(color)
                                        .clickable { /* select color */ }
                                        .padding(4.dp)
                                )
                            }
                        }
                    }

                    item {
                        Text(
                            "Total price EGP ${product.data?.price}",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                        )
                    }

                    item {
                        Button(
                            onClick = { /* Add to cart */ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text("Add to cart")
                        }
                    }
                }
            }
        }
        is Resource.Error -> {
            Text(
                text = detailsState.message ?: "Error occurred",
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}


