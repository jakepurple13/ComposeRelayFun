package com.programmersbox.relayfun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programmersbox.relayfun.hellocard.HelloCard
import com.programmersbox.relayfun.newscard.NewsCard
import com.programmersbox.relayfun.newscard.View
import com.programmersbox.relayfun.ui.theme.RelayFunTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RelayFunTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String) {
    Scaffold { p ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(p),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello $name!")
            LocalIndication.current
            HelloCard(
                titleTextContent = "Hello $name!",
                image = rememberVectorPainter(image = Icons.Default.Add)
            )
            NewsCard(
                view = View.HeroItem,
                thumbnail = rememberVectorPainter(image = Icons.Default.Add),
                headline = "Headline",
                author = "Author",
                date = "Today",
            )
            NewsCard(
                view = View.AudioItem,
                thumbnail = rememberVectorPainter(image = Icons.Default.Add),
                headline = "Headline",
                author = "Author",
                date = "Today",
                onMenuTapped = { println("Hello") }
            )
            NewsCard(
                view = View.ArticleItem,
                thumbnail = rememberVectorPainter(image = Icons.Default.Add),
                headline = "Headline",
                author = "Author",
                date = "Today",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RelayFunTheme {
        Greeting("Android")
    }
}