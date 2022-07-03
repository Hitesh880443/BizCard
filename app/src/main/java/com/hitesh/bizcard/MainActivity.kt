package com.hitesh.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitesh.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyBizCard()
                }
            }
        }
    }
}

@Composable
fun MyBizCard() {
    val buttonClickState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .width(200.dp)
                .height(200.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color.White,
        ) {

            Column(
                modifier = Modifier.size(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                Divider(thickness = 2.dp)
                CreateInfo()
                Button(onClick = {
                    Log.d("clicked", "MyBizCard: Button")
                    buttonClickState.value = !buttonClickState.value
                }) {
                    Text(
                        text = stringResource(R.string.portfolio),
                        style = MaterialTheme.typography.button
                    )
                }

                if (buttonClickState.value) {
                    PortfolioContent()
                } else {
                    Box() {

                    }
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PortfolioContent() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            border = BorderStroke(2.dp, Color.LightGray),
            shape = RoundedCornerShape(5.dp)
        ) {
            Portfolio(
                data = listOf(
                    "Project 1",
                    "Project 2",
                    "Project 3",
                    "Project 4",
                    "Project 5",
                    "Project 6",
                    "Project 7",
                    "Project 8",
                    "Project 9",
                    "Project 10",
                    "Project 11",
                    "Project 12",
                    "Project 13",
                    "Project 14",
                    "Project 15",
                    "Project 16",
                    "Project 17",
                    "Project 18",
                    "Project 19",
                    "Project 20"
                )
            )
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colors.surface)
                ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier.padding(
                            8.dp
                        )
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier.padding(10.dp),
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Sub Title of this project",
                            modifier = Modifier.padding(10.dp),
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Hitesh Sutar",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary
        )
        Text(
            text = "Android Developer",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(3.dp)
        )

        Text(
            text = "@me_hiteshh",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(3.dp)
        )

    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
        border = BorderStroke(0.5.dp, Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_person),
            contentDescription = stringResource(R.string.profile_pic),
            modifier = modifier.size(130.dp),
            contentScale = ContentScale.Crop
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardTheme {
        MyBizCard()
    }
}