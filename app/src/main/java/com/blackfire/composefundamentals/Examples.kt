package com.blackfire.composefundamentals

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blackfire.composefundamentals.ui.theme.ComposeFundamentalsTheme

class Examples : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposeFundamentalsTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
                    examplesUi()
//                }
//            }
        }
    }
}




@Composable
fun examplesUi() {

    var examplesList = mutableListOf<String>()
    for (i in 1..60) {
        examplesList.add("Example $i")
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tkinter Examples",
                        color = Color(0XFF1B1B1B),
                        fontSize = 24.sp
                    )
                },
                backgroundColor = Color(0xFFDDDDDD),
                modifier = Modifier.border(
                    color = Color(0xFF1B1B1B),
                    width = 1.dp,
                    shape = RoundedCornerShape(
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp
                    )
                )
            )
        }
    ) { paddingValues ->
        paddingValues
        val context = LocalContext.current
        LazyColumn {
            items(examplesList) { example ->
                Spacer(modifier = Modifier.height(10.dp))
                customListItem(text = example, context = context)
            }
        }

    }
}


