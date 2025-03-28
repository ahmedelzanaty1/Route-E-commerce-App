package com.example.routee_commerceapp.presentation.Screens.SignUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.routee_commerceapp.R
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.presentation.theme.darkblue
import com.example.routee_commerceapp.presentation.theme.mainblue
import com.example.routee_commerceapp.presentation.viewmodel.Auth.SignUpViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    navigateToHome: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    val signUpState = viewModel.registerState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = mainblue)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Name
            Text(
                text = "User Name",
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(color = Color.White, shape = CircleShape)
            )

            // Phone Number
            Text(
                text = "Phone Number",
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone Number") },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(color = Color.White, shape = CircleShape)
            )

            // Email
            Text(
                text = "Email",
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(color = Color.White, shape = CircleShape)
            )

            // Password
            Text(
                text = "Password",
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
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
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(color = Color.White, shape = CircleShape)
            )

            // Password Instructions
            Text(
                text = "Password must contain: Capital letters, numbers, and symbols.",
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 12.sp
            )

            // Error Message
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    if (name.isEmpty() || !phone.matches(Regex("^01[0-9]{9}$")) ||
                        !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() ||
                        !password.matches(Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#\$%^&+=]).{8,}$"))
                    ) {
                        errorMessage = "Invalid input. Please check your details."
                    } else {
                        viewModel.register(name, email, password, phone)
                    }
                },
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = CircleShape
            ) {
                Text(text = "Sign Up", color = darkblue)
            }

            // Handling State
            when (val result = signUpState.value) {

                is Resource.Success<*> -> {
                    LaunchedEffect(Unit) {
                        navigateToHome()
                    }
                }
                is Resource.Error<*> -> {
                    errorMessage = result.message ?: "An error occurred"
                }
                else -> {}
            }
        }
    }
}
