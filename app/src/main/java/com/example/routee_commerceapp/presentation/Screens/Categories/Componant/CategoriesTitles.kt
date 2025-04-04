package com.example.routee_commerceapp.presentation.Screens.Categories.Componant

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.routee_commerceapp.domain.model.home.Categories.CategoryModel
import com.example.routee_commerceapp.presentation.theme.darkblue

@Composable
fun CategoriesItem(
    modifier: Modifier = Modifier,
    category: CategoryModel,
    onCategorySelected: (CategoryModel) -> Unit,
    isSelected: Boolean
) {
    Row(
        modifier = modifier
            .fillMaxHeight()
            .clickable { onCategorySelected(category) }
            .background(if (isSelected) Color.White else Color.Transparent)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(40.dp)
                    .background(Color.Blue , shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        Text(
            text = category.name ?: "",
            fontSize = 14.sp,
            color = darkblue,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

