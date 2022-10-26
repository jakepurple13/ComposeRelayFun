package com.programmersbox.relayfun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programmersbox.relayfun.hellocard.HelloCard
import com.programmersbox.relayfun.newscard.NewsCard
import com.programmersbox.relayfun.newscard.View
import com.programmersbox.relayfun.statuscard.StatusCard
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

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello $name!")
        MyChip(text = "Hello there!")
        StatusCard(
            chipText = "Hello there!",
            modifier = Modifier.fillMaxWidth()
        )
        StatusCard(
            chipText = "Hello there!",
            modifier = Modifier.fillMaxWidth()
        )
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RelayFunTheme(darkTheme = true) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Greeting("Android")
        }
    }
}

@Composable
fun MyChip(
    modifier: Modifier = Modifier,
    design: String = "Configuration=Success",  // See note below
    text: String
) {
    when (design) {
        "Configuration=Success" -> SuccessChip(modifier = modifier, text = text)
        "Configuration=Warning" -> WarningChip(modifier = modifier, text = text)
        "Configuration=Error" -> ErrorChip(modifier = modifier, text = text)
    }
}

@Composable
fun SuccessChip(
    text: String,
    modifier: Modifier = Modifier
) {
    BaseChip(modifier = modifier, text = text, backgroundColor = Color(0xFFC4EED0))
}

@Composable
fun WarningChip(
    text: String,
    modifier: Modifier = Modifier
) {
    BaseChip(modifier = modifier, text = text, backgroundColor = Color(0xFFFFDDAB))
}

@Composable
fun ErrorChip(
    text: String,
    modifier: Modifier = Modifier
) {
    BaseChip(modifier = modifier, text = text, backgroundColor = Color(0xFFF2B8B5))
}

@Composable
fun BaseChip(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = Color.LightGray
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(size = 8.dp))
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(12.dp, 6.dp)
        ) {
            Text(
                "Mapped Chip!",
                color = Color(0xFF001D35)
            )
            Text(
                text = text,
                color = Color(0xFF001D35),
                fontSize = 14.sp
            )
        }
    }
}