package com.blackfire.composefundamentals

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.blackfire.composefundamentals.ui.theme.ComposeFundamentalsTheme
import com.google.android.gms.ads.MobileAds

class WebviewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this)
        val appBarTitle = intent.getStringExtra("title")
        setContent {
            ComposeFundamentalsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
//                                    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                                        Text(
                                            text = appBarTitle.toString(),
                                            color = Color(0xFF1B1B1B),
                                            fontSize = 24.sp,
//                                            fontStyle = FontStyle./
                                        )
//                                    }
                                },
                                backgroundColor = Color(0xFFDDDDDD),
                                modifier = Modifier.border(
                                    color = Color(0xFF1B1B1B),
                                    width = 1.dp,
                                    shape = RoundedCornerShape(
                                        bottomStart = 8.dp,
                                        bottomEnd = 12.dp
                                    )
                                )
                            )
                        },
                        content = {
                            paddingValues -> paddingValues
                            val url = intent.getStringExtra("url")

                                Column {
                                    if(url != null) {
                                        webView(url = url)
                                    }
                                        BannerAdView()
                                }
                        }
                    )

                }
            }
        }
    }
}



