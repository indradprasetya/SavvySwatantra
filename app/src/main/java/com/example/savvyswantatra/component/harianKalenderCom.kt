package com.example.savvyswantatra.component

import android.provider.ContactsContract.Data
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.DummyData
import com.example.savvyswantatra.model.TransaksiKalender
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.*
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*
import com.example.savvyswantatra.model.KalenderData


@Composable
fun HarianKalenderItem(
kalender1 : com.example.savvyswantatra.model.KalenderData,
modifier: Modifier,
){
Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)

        ) {
    Box(
        modifier = Modifier
            .requiredSize(50.dp)
    ) {
        Box( modifier = Modifier.clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(id = kalender1.image),
                contentDescription = "Makanan",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )

        }
        Image(
            painter = painterResource(id = kalender1.icon),
            contentDescription = "Pengeluaran Icon",
            modifier = Modifier
                .requiredSize(20.dp)
                .align(Alignment.BottomEnd)

        )
    }
    Spacer(modifier = Modifier.height(1.dp))
    Column(modifier = Modifier .padding(8.dp)) {
                Text(

                    text = kalender1.kategori,
                    color = Color.Black,
                    style = Typography.bodyMedium
                        )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = kalender1.deskripsi,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = PurpleSavvy2
                    )
                    Text(
                        text = kalender1.harga,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = PurpleSavvy2
                    )
                }
            }
        }
        }
