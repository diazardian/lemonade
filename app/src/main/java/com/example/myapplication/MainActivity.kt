package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "screen1") {
                        composable("screen1") { Screen1(navController) }
                        composable("screen2") { Screen2(navController) }
                        composable("screen3") { Screen3(navController) }
                        composable("screen4") { Screen4(navController) }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1(navController: NavHostController) {
    Column {
        CenterAlignedTopAppBar(
            title = { Text("Lemonade") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow)
        )
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = "https://w7.pngwing.com/pngs/643/856/png-transparent-lemon-computer-icons-lemons-farting-natural-foods-food-orange.png")
                            .allowHardware(false)
                            .build()
                    ),
                    contentDescription = "Go to Screen 2",
                    modifier = Modifier
                        .clickable { navController.navigate("screen2") }
                        .size(300.dp)
                )
                Text(text = "Go to Screen 2")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavHostController) {
    var clickAmount = 0
    val randomNumber = Random.nextInt(2, 4) // Generates a random number between 2 and 4
    Column {
        CenterAlignedTopAppBar(
            title = { Text("Lemonade") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow)
        )
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = "https://down-id.img.susercontent.com/file/2d71ca285efa1955fda5bae3eccc10f3")
                            .allowHardware(false)
                            .build()
                    ),
                    contentDescription = "Go to Screen 3",
                    modifier = Modifier
                        .size(250.dp)
                        .clickable {
                        clickAmount += 1
                        if (randomNumber == clickAmount) {
                            navController.navigate("screen3")
                        }
                    }
                )
                Text("Go to Screen 3")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen3(navController: NavHostController) {
    Column {
        CenterAlignedTopAppBar(
            title = { Text("Lemonade") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow)
        )
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWHytsk8TH4TBUxOm3SJGxpoe76_gJz00NGQ&s")
                            .allowHardware(false)
                            .build()
                    ),
                    contentDescription = "Go to Screen 4",
                    modifier = Modifier
                        .size(300.dp)
                        .clickable { navController.navigate("screen4") }
                )
                Text("Go to Screen 4")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen4(navController: NavHostController) {
    Column {
        CenterAlignedTopAppBar(
            title = { Text("Lemonade") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow)
        )
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = "https://img.freepik.com/premium-vector/empty-glass_311865-10043.jpg")
                            .allowHardware(false)
                            .build()
                    ),
                    contentDescription = "Go to Screen 1",
                    modifier = Modifier
                        .size(350.dp)
                        .clickable { navController.navigate("screen1") }
                )
                Text("Go to Screen 1")
            }
        }
    }
}