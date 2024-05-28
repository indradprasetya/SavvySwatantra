package com.example.savvyswantatra.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savvyswantatra.component.Image.bankList
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy

@Composable
fun Anggaran_card(imageResources: Int, label:String, nominal:String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .width(320.dp) // Set the width of the card to 318.dp
                .height(110.dp), // Set the height of the card to 141.dp
            colors = CardDefaults.cardColors(containerColor = PurpleSavvy1)
        ){
            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Saldo Total",
                        style = Typography.labelSmall,
                        fontSize = 14.sp
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(id = imageResources) ,
                            contentDescription = "",
                            modifier = Modifier
                                .requiredSize(40.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                        )
                        Text(
                            text = label,
                            style = Typography.labelSmall,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                    Text(
                        text = "Rp. $nominal",
                        style = Typography.displayMedium,
                        color = OrangeSavvy
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun BankList() {
    val selectedOption = remember { mutableStateOf(bankList[0]) }
    val pagerState = rememberPagerState(pageCount = { bankList.size })

    HorizontalPager(state = pagerState) { page ->
        FlowRow(
            // Tambahkan ini untuk mengatur ke tengah
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(horizontal = 38.dp)
        ) {
            bankList.chunked(4).forEach { banks ->
                banks.forEach { bank ->
                    Surface(
                        shape = RoundedCornerShape(5.dp),
                        border = BorderStroke(
                            width = 2.dp,
                            color = if (bank == selectedOption.value) Color(0xFFFFA500) else Color.Transparent
                        ),
                        color = WhiteSavvy
                    ) {
                        Image(
                            painter = painterResource(id = bank),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    selectedOption.value = bank
                                }
                        )
                    }
                }
            }
        }

    }
}

