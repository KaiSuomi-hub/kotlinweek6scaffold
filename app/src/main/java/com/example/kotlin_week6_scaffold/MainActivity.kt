package com.example.kotlin_week6_scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_week6_scaffold.ui.theme.Kotlinweek6scaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlinweek6scaffoldTheme {
                ScaffoldApp()
            }
        }
    }
}

@Composable
fun ScaffoldApp() {
    Scaffold(
        topBar = {
            MyTopBar()
        },
        content = { paddingValues ->
            Text(
                text = "Content",
                modifier = Modifier.padding(paddingValues).padding(start = 16.dp, end = 16.dp)
            )
        },
        bottomBar = {
            BottomAppBar(
                content = {
                    IconButton(
                        onClick = { /* Handle home icon click */ }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Home")
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(){
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(text = "My App") },
        navigationIcon = {
            IconButton(
                onClick = { /* Handle navigation icon click */ }
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(
                onClick = { expanded = !expanded }
            ) {
                Icon(Icons.Filled.MoreVert, contentDescription = "Search")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                DropdownMenuItem(
                    text = { Text(text = "Info") },
                    onClick = { /* Handle option 1 click */ }
                )
                DropdownMenuItem(
                    text = { Text(text = "Settings") },
                    onClick = { /* Handle option 2 click */ }
                )
            }
        }

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTop(){

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlinweek6scaffoldTheme {
    }
}