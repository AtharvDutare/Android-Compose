package com.example.androidcompose

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcompose.dataclasses.item
import com.example.androidcompose.ui.theme.AndroidComposeTheme
import kotlin.collections.listOf
import kotlin.to

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var count=mutableStateOf(0)
        //enableEdgeToEdge()
        setContent {
            AndroidComposeTheme {
                Scaffold() {
                    Box(modifier = Modifier.statusBarsPadding()) {
                        LazyColumnWithStickyHeader()
                    }
                }
            }
        }

    }
}

//@Preview(showBackground = true, widthDp = 300, heightDp = 500)
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



@Composable
fun Fomo() {
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(10.dp)
            .border(5.dp, Color.Red)
            .padding(20.dp)
            .border(5.dp,Color.Black)
            .padding(80.dp)
            .border(2.dp,Color.Blue)
    ) {
        Text(
            text = "Hello programming",
            modifier = Modifier
                .padding(start = 15.dp,top=4.dp),
            fontSize = 25.sp,
            textDecoration= TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            )
        )
        Text("helloooo fofofofo")

        Image(painterResource( R.drawable.ic_launcher_background)
            , contentDescription = "fhajfkhas"
        )

        FilledTonalButton(
            onClick = {}
        ) {

        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun understandngstate(count: MutableState<Int>) {

    Column (
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(25.dp)
        ,horizontalAlignment=Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center

    ) {
        Button(
            onClick = {
                count.value++
                Log.i("innerButton","the count value is ${count.value}")
            }

        ) {
            Text(text = "increaement the counter")
        }
        Text("the value of counter is ${count.value}")
        var ara=remember{mutableStateOf("")}
        var arar by remember{mutableStateOf("")}

    }
}


@Composable
fun CheckBoxExample() {
    val context=LocalContext.current
    var checked by remember{
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked=it
                Toast.makeText(context, "is Checked $it" , Toast.LENGTH_SHORT).show()
            }

        )
        Switch(
            checked = checked,
            onCheckedChange = {
                checked=it
                Toast.makeText(context, "is Checked $it" , Toast.LENGTH_SHORT).show()
            }

        )

    }
}

@Composable
fun Trttrt() {
    Column(
        modifier = Modifier.verticalScroll(
            state = rememberScrollState()
        )
    ) { }
}



@ExperimentalFoundationApi
@Composable
fun LazyColumnWithStickyHeader() {

    val groupedItem: Map<String, List<item>> = mapOf(
        "Fruits" to listOf(
            item("Apple", "Red and sweet fruit", R.drawable.ic_launcher_background),
            item("Banana", "Soft yellow fruit", R.drawable.ic_launcher_background),
            item("Mango", "Juicy tropical fruit", R.drawable.ic_launcher_background)
        ),
        "Vegetables" to listOf(
            item("Carrot", "Orange root vegetable", R.drawable.ic_launcher_background),
            item("Tomato", "Red salad favorite", R.drawable.ic_launcher_background),
            item("Spinach", "Leafy green veggie", R.drawable.ic_launcher_background)
        ),
        "Dairy" to listOf(
            item("Milk", "Fresh cow milk", R.drawable.ic_launcher_background),
            item("Cheese", "Aged cheddar block", R.drawable.ic_launcher_background)
        ),
        "Snacks" to listOf(
            item("Chips", "Crispy salted potato chips", R.drawable.ic_launcher_background),
            item("Chocolate", "Sweet dark chocolate bar", R.drawable.ic_launcher_background)
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        state = rememberLazyListState()
    ) {
        groupedItem.forEach{
            (key,value)->
            stickyHeader {
                MyCustomHeader(key)
            }
            items(value) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    MyCustomItem(item)
                }



            }
        }
    }
}


@Composable
fun MyCustomHeader(title:String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp) // Adjust height as needed
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.9f), // Dense at the top
                        Color.Black.copy(alpha = 0.4f), // Fading in the middle
                        Color.Transparent             // Fully clear at the bottom
                    ),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )
    }
}
//@Preview(showBackground = true)
@Composable
fun MyCustomItem(item: item) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
        , elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ) {
        Column() {
            Image(
                painter = painterResource(item.img),
                contentDescription = item.desc,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}




