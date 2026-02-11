package com.example.androidcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            previewItem()
        }
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
private fun previewUi() {

    Text(
        text = "Hello",
        color=Color.White,
        modifier = Modifier.background(Color.Blue)
            .size(200.dp)
            .border(4.dp,Color.Red)

    )

//    Column() {
//        ListViewItem(
//            R.drawable.ic_launcher_background,
//            "Atharv Dutare",
//            "Software developer"
//        )
//        ListViewItem(
//            R.drawable.ic_launcher_background,
//            "Atharv Dutare",
//            "Software developer"
//        )
//        }

}


@Composable
fun ListViewItem(imgId: Int, name: String, occupation: String) {
    Row(Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "",
            Modifier.size(40.dp)
        )
        Column() {
            Text(
                text = name,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = occupation,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp
            )
        }
    }

}


@Composable
fun TextInput() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = { Text(text = "enter message") }
    )
}


