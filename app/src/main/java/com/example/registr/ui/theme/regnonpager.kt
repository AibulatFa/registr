package com.example.registr.ui.theme

import android.annotation.SuppressLint

class regnonpager {
}



@Composable
fun LoginScreen(navController: NavHostController) {
    TopAppBar {
        TextButton(onClick = { navController.navigate(Screen.Login.route) }) {
            Text("Login",
                color = Color.Black)
        }

        TextButton(onClick = { navController.navigate(Screen.Registration.route) }) {
            Text("Registration",
                color = Color.Black) }

    }
    Column(
        modifier = Modifier
            .fillMaxSize()

            .wrapContentSize(Alignment.Center)
    ) {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Login") })

        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.visibility)
        else
            painterResource(id = R.drawable.ic_baseline_visibility_off_24)

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = { Text(text = "Password") },
            label = { Text(text = "Password") },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { },
            // Uses ButtonDefaults.ContentPadding by default

            contentPadding = PaddingValues(
                start = 101.dp,
                top = 12.dp,
                end = 101.dp,
                bottom = 12.dp

            )
        ) {


            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(Icons.Filled.Person, contentDescription = "Войти")
            Text("Войти")
        }
    }
}

@SuppressLint("RestrictedApi")
@Composable
fun RegistrationScreen(navController: NavHostController) {
    TopAppBar {
        TextButton(onClick = { navController.navigate(Screen.Login.route) }) {
            Text("Login",
                color = Color.Black)
        }

        TextButton(onClick = { navController.navigate(Screen.Registration.route) }) {
            Text("Registration",
                color = Color.Black) }

    }
    Column(
        modifier = Modifier
            .fillMaxSize()

            .wrapContentSize(Alignment.Center)
    ) {
        var name by remember { mutableStateOf("") }

        val db = Firebase.firestore

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Имя") })

        var telephone by remember { mutableStateOf("") }

        OutlinedTextField(
            value = telephone,
            onValueChange = { telephone = it },
            label = { Text("Telephone") })


        var email by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") })


        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.visibility)
        else
            painterResource(id = R.drawable.ic_baseline_visibility_off_24)

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = { Text(text = "Password") },
            label = { Text(text = "Password") },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))


        Button(
            onClick = { },

            // Uses ButtonDefaults.ContentPadding by default
            contentPadding = PaddingValues(
                start = 70.dp,
                top = 12.dp,
                end = 70.dp,
                bottom = 12.dp


            )


        ) {


            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(Icons.Filled.Person, contentDescription = "Регистрация")
            Text("Регистрация   ")
        }
    }

}
