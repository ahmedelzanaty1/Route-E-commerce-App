package com.example.routee_commerceapp.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.routee_commerceapp.R
import com.example.routee_commerceapp.presentation.theme.RouteEcommerceAppTheme
import com.example.routee_commerceapp.presentation.theme.mainblue
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RouteEcommerceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SplashScreen(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navigate: () -> Unit = {}) {
    LaunchedEffect(key1 = true) {
        kotlinx.coroutines.delay(3000)
        navigate()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = mainblue)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.up),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Image(
                painter = painterResource(id = R.drawable.down),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Splash() {

    SplashScreen()
}

