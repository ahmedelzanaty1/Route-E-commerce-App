package com.example.routee_commerceapp.presentation.componants

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.routee_commerceapp.R
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.presentation.theme.darkblue
import com.example.routee_commerceapp.presentation.theme.mainblue
import com.example.routee_commerceapp.presentation.viewmodel.Auth.LoginViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier ,
                navController: NavController,
                navigateToHome: () -> Unit,
                navigateToSignUp: () -> Unit,
                viewModel: LoginViewModel = hiltViewModel()
                ) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val loginState = viewModel.loginState.collectAsState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = mainblue)) {
        Column (modifier = Modifier.fillMaxSize()){
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(25.dp).fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Welcome Back To Route"
                , color = Color.White
                , modifier = Modifier.padding(start = 10.dp
                ) , fontWeight = FontWeight.Bold
                , fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Sign in to continue"
                , color = Color.White
                , modifier = Modifier.padding(start = 10.dp
                ) , fontWeight = FontWeight.Medium
                , fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Email"
                , color = Color.White
                , modifier = Modifier.padding(start = 10.dp
                ) , fontWeight = FontWeight.Medium ,
                fontSize = 15.sp)
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.padding(10.dp).fillMaxWidth().background(color = Color.White ,
                    shape = CircleShape)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Password"
                , color = Color.White
                , modifier = Modifier.padding(start = 10.dp
                ) , fontWeight = FontWeight.Medium ,
                fontSize = 15.sp)
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = painterResource(id = if (passwordVisible) R.drawable.hide else R.drawable.hide),
                            modifier = Modifier.size(25.dp),
                            contentDescription = "Toggle password visibility"

                        )

                    }
                },
                modifier = Modifier.padding(10.dp).fillMaxWidth().background(color = Color.White ,
                    shape = CircleShape)
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "Forgot Password?"
                , color = Color.White
                , modifier = Modifier.padding(start = 10.dp
                ) , fontWeight = FontWeight.Medium ,
                textAlign = TextAlign.End,
                fontSize = 15.sp)
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { viewModel.login(email, password) },
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "Login", color = darkblue)
            }

            Spacer(modifier = Modifier.height(4.dp))
            TextButton(onClick = navigateToSignUp , modifier = Modifier.padding(10.dp).fillMaxWidth() ,
                ) {

                Text(text = "Don't have an account? Sign Up" , color = Color.White )
            }
            when (val result = loginState.value) {

                is Resource.Success -> {
                    LaunchedEffect(Unit) {
                        navigateToHome()
                    }
                }
                is Resource.Error -> {
                    Text(
                        text = result.message ?: "An error occurred",
                        color = MaterialTheme.colorScheme.error
                    )
                }
                else -> {}
            }

        }

    }

}

