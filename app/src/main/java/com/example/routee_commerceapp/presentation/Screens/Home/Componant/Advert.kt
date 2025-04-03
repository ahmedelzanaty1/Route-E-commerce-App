package com.example.routee_commerceapp.presentation.Screens.Home.Componant

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.routee_commerceapp.R

@Composable
fun Advert(modifier: Modifier = Modifier) {
    Box (modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        .padding(5.dp)){
        Image(
            painter = painterResource(id = R.drawable.adv),
            contentDescription = "Advert",
            modifier = Modifier.fillMaxWidth()
            , contentScale = ContentScale.Crop

        )
    }

}
