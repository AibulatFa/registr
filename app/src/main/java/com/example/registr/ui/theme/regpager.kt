package com.example.registr.ui.theme

import android.annotation.SuppressLint

@ExperimentalPagerApi
@Composable
fun PersonScreen(navController: NavHostController)
{
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        var tabIndex = rememberSaveable { mutableStateOf(0) }
        val pagerState = rememberPagerState()
        val scope = rememberCoroutineScope()
        val tabTitles = listOf<String>("Login", "Register")
        val white = Color(0xffffffff)
        val ash7a = Color(0xFFBB86FC)
        val pearl = Color(0xFF6200EE)






        Column {
            TabRow(selectedTabIndex = tabIndex.value,
                backgroundColor = colorResource(id = R.color.purple_200),
                modifier = Modifier
                    .background(color = Color.Transparent),
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier
                            .pagerTabIndicatorOffset(
                                pagerState,
                                tabPositions
                            )
                            .height(0.dp)
                            .size(0.dp)
                    )
                }) {
                tabTitles.forEachIndexed { index, title ->
                    val tabColor = remember {
                        Animatable(white)
                    }

                    val textColor = remember {
                        Animatable(ash7a)
                    }

                    LaunchedEffect(key1 = pagerState.currentPage == index) {
                        tabColor.animateTo(if (pagerState.currentPage == index) pearl else white)
                        textColor.animateTo(if (pagerState.currentPage == index) white else ash7a)
                    }

                    Tab(
                        selected = pagerState.currentPage == index,
                        modifier = Modifier
                            .background(
                                color = tabColor.value
                            ),
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }) {
                        Text(
                            tabTitles[index],
                            modifier = Modifier.padding(vertical = 10.dp),
                            style = TextStyle(
                                color = textColor.value,

                                )
                        )
                    }

                }
            }
            HorizontalPager(
                count = tabTitles.size,
                state = pagerState,
            ) { tabIndex ->
                if (tabIndex == 1) {
                    LoginScreen()
                } else {
                    RegistrationScreen()
                }
            }
        }
    }
}



@Composable
fun LoginScreen() {
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
fun RegistrationScreen() {
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


