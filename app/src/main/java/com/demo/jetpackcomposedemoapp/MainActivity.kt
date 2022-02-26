package com.demo.jetpackcomposedemoapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.jetpackcomposedemoapp.ui.theme.JetpackComposeDemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun UserCard() {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.default_user_icon),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(12.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.user_name),
                    Modifier.padding(12.dp)
                )
                Button(
                    onClick = {
                        //handle onClick here
                    },
                    Modifier.padding(12.dp)
                ) {
                    Text(text = "View Profile")
                }
            }
        }
    }
}

data class User(
    val id: Int
)

val users = mutableStateListOf<User>(
    User(1)
)

@Composable
fun UserList(users: List<User>) {

    val name = remember { mutableStateOf("default_value") }

    LazyColumn {
        items(users) { user ->
            UserCard()
        }
    }
}

@Composable
fun MainContent() {
    val users = remember { users }
    Box(modifier = Modifier.fillMaxSize()) {
        UserList(users = users)
        Button(
            onClick = {
                users.add(User(1))
            },
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(text = "Add More")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        JetpackComposeDemoAppTheme {
            MainContent()
        }
    }
}
