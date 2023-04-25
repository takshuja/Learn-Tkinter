package com.blackfire.composefundamentals

import android.content.Context
import android.content.Intent
import android.graphics.fonts.FontStyle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun navigationButton(
    title: String,
    appBarTitle: String=title,
    url: String = "https://github.com/takshuja/Learn-Tkinter",
    code: Int = 0,
    height: Dp = 60.dp,
    margin: Dp = 25.dp
) {
    val context = LocalContext.current
    OutlinedButton(
        onClick = {
            when (code) {
                0 -> {
                    val intent = Intent(context, WebviewActivity::class.java)
                    val url = url
                    intent.putExtra("url", url)
                    intent.putExtra("title", appBarTitle)
                    context.startActivity(intent)
                }
                1 -> {
                    val intent = Intent(context, WidgetListActivity::class.java)
                    context.startActivity(intent)
                }
                2 -> {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.putExtra(Intent.EXTRA_TEXT, "Learning Tkinter using this app is so easy! Download Now. ")
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent, "Share app via"))
                }
                3 -> {
                    val intent = Intent(context, Examples::class.java)
                    context.startActivity(intent)
                }
            }
        },
        elevation = ButtonDefaults.elevation(defaultElevation = 8.dp, pressedElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(height)
            .clip(RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Color(0xFF1B1B1B), shape = RoundedCornerShape(12.dp)),

        colors = ButtonDefaults.run { buttonColors(backgroundColor = Color(0xFFDDDDDD)) }//Color(0xFF717C7D))
    ) {
        Text(text = title, color = Color(0xFF1B1B1B), fontSize = 18.sp)
    }
    Spacer(modifier = Modifier.height(margin))
}



@Composable
fun webView(url: String) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            )
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun customListItem(text:String, context: Context, url:String = "https://github.com/takshuja/Learn-Tkinter", height: Dp = 10.dp) {
    Spacer(modifier = Modifier.height(height))
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .border(
                    width = 1.dp,
                    color = Color(0xFF1B1B1B),
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(
                    shape = RoundedCornerShape(12.dp)
                )
                .background(color = Color(0xFFDDDDDD)),
            onClick = {
                Toast.makeText(context, "$text Clicked!", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, WebviewActivity::class.java)
//                var url = url
                intent.putExtra("url", url)
                intent.putExtra("title", text)
                context.startActivity(intent)
            },
            backgroundColor = Color(0xFFDDDDDD),
        ) {
            Row {
                Text(
                    text = text,
                    modifier = Modifier.padding(20.dp),
                    style = TextStyle(
                        color = Color(0XFF1B1B1B),
                        fontSize = 20.sp
                    )
                )
            }
        }
    }
}



@Composable
fun BannerAdView() {
    AndroidView(modifier = Modifier
        .fillMaxWidth()
        .fillMaxSize(),
        factory = {
        context ->  AdView(context).apply {
            setAdSize(AdSize.BANNER)
//            adUnitId = "ca-app-pub-3940256099942544/1033173712"
            adUnitId = "ca-app-pub-3940256099942544/6300978111"
            loadAd(AdRequest.Builder().build())
            }
        }
    )
}



@Composable
fun NavigationDrawer() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
//        Text("Drawer", fontSize = 100.sp)
        appLogo()
        LazyColumn(content = {
            item {
//                ClickableText(text = , onClick = )
                Spacer(modifier = Modifier.height(30.dp))
                drawerItem(text = "Settings")
                drawerItem(text = "Rate App")
            }
        })
    }
}


@Composable
fun appLogo() {
    val pyLogo: Painter = painterResource(id = R.drawable.tkinter_app_logo)
    Spacer(modifier = Modifier.height(20.dp))
    Image(
        painter = pyLogo,
        contentDescription = "App Logo",
        modifier = Modifier
            .height(140.dp)
            .width(150.dp)
    )
    Spacer(modifier = Modifier.height(0.dp))
}


@Composable
fun drawerItem(text: String, fontSize: TextUnit = 25.sp) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .height(30.dp),
//        backgroundColor = Color(0xFF),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(Icons.Default.Settings, contentDescription = "")
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = text,
                fontSize = fontSize,
                color = Color(0xFF1B1B1B),
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}