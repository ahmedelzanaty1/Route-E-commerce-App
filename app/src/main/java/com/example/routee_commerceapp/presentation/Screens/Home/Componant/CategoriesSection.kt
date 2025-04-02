package com.example.routee_commerceapp.presentation.Screens.Home.Componant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.routee_commerceapp.R
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.domain.model.home.Categories.CategoryModel
import com.example.routee_commerceapp.presentation.theme.darkblue
import com.example.routee_commerceapp.presentation.viewmodel.Home.HomeViewModel

@Composable
fun CategoriesSection(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val categoriesState = viewModel.categoriesState.collectAsState()

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        CategoryTitle(title = "Categories", sub = "See All")
        Spacer(modifier = Modifier.height(8.dp))

        when (val result = categoriesState.value) {
            is Resource.Loading -> {
                Text(text = "Loading...", fontSize = 20.sp)
            }
            is Resource.Success -> {
                LazyHorizontalGrid(
                    rows = androidx.compose.foundation.lazy.grid.GridCells.Fixed(1),
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(result.data ?: emptyList()) { category ->
                        CategoryCard(category = category)
                    }
                }
            }
            is Resource.Error -> {
                Text(text = result.message ?: "Error occurred", color = darkblue)
            }
        }
    }
}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    category: CategoryModel
) {
    Column(
        modifier = modifier
            .width(100.dp)
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
        ) {
            GlideImage(
                model = category.image,
                contentDescription = category.name,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = category.name ?: "Unknown",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = darkblue,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp),
            maxLines = 2
        )
    }
}



@Composable
fun CategoryTitle(modifier: Modifier = Modifier, title: String, sub: String) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(11.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                color = darkblue,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = sub,
                color = darkblue,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

