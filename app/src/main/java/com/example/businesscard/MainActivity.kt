package com.example.businesscard

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFd2e8d4)
                ) {
                    CompleteScreen()
                }
            }
        }
    }
}

@Composable
fun CompleteScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.weight(1f)) {
            CenterScreen(
                stringResource(R.string.business_card_name),
                stringResource(R.string.business_card_title),
                Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            BottomScreen(
                stringResource(R.string.my_number),
                stringResource(R.string.my_google_dev_id),
                stringResource(R.string.my_mail),
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun CenterScreen(name: String, title: String, modifier: Modifier = Modifier.fillMaxSize()) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier
                .padding(top = 170.dp, start = 125.dp, end = 125.dp)
                .background(color = Color(0xFF073042))
        )
        Text(
            text = name,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 8.dp)
        )
        Text(
            text = title,
            fontSize = 15.sp,
            color = Color(0XFF1e7c4c),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
    }
}

@Composable
fun BottomScreen(number: String, link: String, mail: String, modifier: Modifier = Modifier) {
    val callIcon = painterResource(R.drawable.call)
    val linkIcon = painterResource(R.drawable.link)
    val mailIcon = painterResource(R.drawable.mail)
    Column(modifier = modifier.padding(start = 90.dp, end = 70.dp, top = 230.dp)) {
        Row(modifier = Modifier.padding(bottom = 5.dp)) {
            Image(
                painter = callIcon,
                contentDescription = null,
                Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
            )
            Text(
                text = number,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(start = 8.dp, top = 1.dp)
                    .weight(8f)
            )
        }
        Row(modifier = Modifier.padding(bottom = 5.dp)) {
            Image(
                painter = linkIcon,
                contentDescription = null,
                Modifier.weight(1f)
            )
            Text(
                text = link,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(start = 10.dp, top = 1.dp)
                    .weight(9f)
            )
        }
        Row() {
            Image(
                painter = mailIcon,
                contentDescription = null,
                Modifier.weight(1f)
            )
            Text(
                text = mail,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 10.dp, top = 2.dp)
                    .weight(9f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    CompleteScreen()
}
