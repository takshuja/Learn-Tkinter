package com.blackfire.composefundamentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blackfire.composefundamentals.ui.theme.ComposeFundamentalsTheme

class WidgetListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScaffold()
        }
    }
}


@Composable
fun AppScaffold() {
    Scaffold(
        topBar = {TopAppBar(title = { Text(text="Widgets List", color = Color(0XFF1B1B1B),fontSize = 24.sp) },
            backgroundColor = Color(0xFFDDDDDD),
            modifier = Modifier.border(color = Color(0xFF1B1B1B), width = 1.dp, shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 12.dp)
            )
        )
    },
    ){
            paddingValues -> paddingValues
            val context = LocalContext.current
            LazyColumn{
                item {
                    customListItem(text = "Common Attributes", context = context)
                    customListItem(text = "Tkinter Button", context = context, url = "file:///android_asset/Widgets List/Button/index.html")
                    customListItem(text = "Tkinter Checkbutton", context = context, url = "file:///android_asset/Widgets List/Checkbox/index.html")
                    customListItem(text = "Tkinter Entry", context = context, url = "file:///android_asset/Widgets List/Entry/index.html")
                    customListItem(text = "TKinter Label", context = context, url = "file:///android_asset/Widgets List/Label/index.html")
                    customListItem(text = "Tkinter Toplevel", context = context)
                    customListItem(text = "Tkinter Frame", context = context)
                    customListItem(text = "Tkinter Label", context = context)
                    customListItem(text = "Tkinter Listbox", context = context)
                    customListItem(text = "Tkinter Menubutton", context = context)
                    customListItem(text = "Tkinter Menu", context = context)
                    customListItem(text = "Tkinter Message", context = context)
                    customListItem(text = "Tkinter Radiobutton", context = context)
                    customListItem(text = "Tkinter Scale", context = context, url = "file:///android_asset/Widgets List/Slider/index.html")
                }
            }

    }
}


@Composable
fun appBody() {
    Column(modifier = Modifier
        .fillMaxSize()
//        .background(Color(0xFF0))
        .verticalScroll(rememberScrollState()),//Color(0x22C59e74)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(30.dp))

//        navigationButton("Common Attributes", margin = 30.dp)
//        navigationButton("Tkinter Button", margin = 30.dp)
//        navigationButton("Tkinter Checkbox", margin = 30.dp)
//        navigationButton("Tkinter Entry", margin = 30.dp)
//        navigationButton("Tkinter Label", margin = 30.dp)
//        navigationButton("Tkinter Slider", margin = 30.dp)
//        navigationButton("Tkinter Toplevel", margin = 30.dp)
//        navigationButton("Tkinter RadioButton", margin = 30.dp)
//        navigationButton("Tkinter Frame", margin = 30.dp)


    }
}