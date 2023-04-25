package com.blackfire.composefundamentals

import android.content.res.Resources.Theme
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MainUI()
        }
        MobileAds.initialize(this)
    }
}


@Composable
fun MainUI() {

    appScaffold()
}

@Composable
fun appScaffold() {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
        TopAppBar(title = {
            Row(verticalAlignment = Alignment.CenterVertically) {

                IconButton(
                    onClick = {scope.launch { scaffoldState.drawerState.open() }},
                    content = {
                        Icon(Icons.Default.Menu, contentDescription = "")
                    }
                )
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Learn Tkinter GUI",
                    color = Color(0xFF1B1B1B),
                    fontSize = 24.sp
                )
            }
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
    },
        content = {
            paddingValues -> paddingValues
            body()
        },
        drawerContent = {
            NavigationDrawer()
        }
    )
}



@Composable
fun body() {
    Column(modifier = Modifier.background(color = Color(0xFF))) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(color = Color(0xFF)),//Color(0x22C59e74)),


            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val pyLogo: Painter = painterResource(id = R.drawable.pythonlogo)
            Image(
                painter = pyLogo,
                contentDescription = "Python Image Logo",
                modifier = Modifier
                    .height(140.dp)
                    .width(150.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            val introductionUrl = "file:///android_asset/Introduction/Introduction.html";
            val widgetsUrl = "file:///android_asset/Widgets/index.html"

            navigationButton(title = "Introduction", url = introductionUrl)
            navigationButton("Widgets", url = widgetsUrl)
            navigationButton("Widgets List", code = 1)
            navigationButton("Layout Management")
            navigationButton("Examples", code = 3)
            navigationButton("Share App", code = 2)
        }
        BannerAdView()
    }
}