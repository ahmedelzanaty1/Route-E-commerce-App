package com.example.routee_commerceapp.presentation.Screens.Home.Componant

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.routee_commerceapp.R

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logohome),
            contentDescription = "Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .padding(12.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(25.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Icon",
                tint = Color.Gray,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
            )

            Text(
                text = "What do you search for?",
                color = Color.Gray,
                modifier = Modifier.weight(1f)
            )

            Image(
                painter = painterResource(id = R.drawable.shoppingcart),
                contentDescription = "Shopping Cart",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 8.dp)
            )
        }
    }
}



@Preview(showBackground = true , showSystemUi = true)
@Composable
private fun Shape() {
    SearchBar()

}