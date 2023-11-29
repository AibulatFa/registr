package com.example.registr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                            Login()
                        } else {
                            Register()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Register() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.purple_200))
                .wrapContentSize(Alignment.Center)
        ) {
            var text by remember { mutableStateOf("") }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Login") })

            var password by rememberSaveable { mutableStateOf("") }

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
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

    @Composable
    fun Login() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.purple_200))
                .wrapContentSize(Alignment.Center)
        ) {
            var name by remember { mutableStateOf("") }

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Имя") })

            var email by remember { mutableStateOf("") }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") })


            var Login by remember { mutableStateOf("") }

            OutlinedTextField(
                value = Login,
                onValueChange = { Login = it },
                label = { Text("Login") }

            )


            var Password by rememberSaveable { mutableStateOf("") }

            TextField(
                value = Password,
                onValueChange = { Password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            val checkedState = remember { mutableStateOf(true)}
                Row{
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    modifier = Modifier,
                            colors  = CheckboxDefaults.colors(checkedColor = Color(0xff, 0xb6, 0xc1), checkmarkColor = Color.Gray)
                )
                Text("Запомнить", fontSize = 18.sp)
            }
            Button(
                onClick = {

                },
                // Uses ButtonDefaults.ContentPadding by default
                contentPadding = PaddingValues(
                    start = 70.dp,
                    top = 12.dp,
                    end = 70.dp,
                    bottom = 12.dp

                )

            ) {


                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(Icons.Filled.Person, contentDescription = "Войти")
                Text("Регистрация   ")
            }
        }

    }
}