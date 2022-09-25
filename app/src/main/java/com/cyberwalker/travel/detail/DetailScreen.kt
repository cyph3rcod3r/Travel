/*
 * Copyright 2022 Cyph3rCod3r
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cyberwalker.travel.detail


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberwalker.travel.R
import com.cyberwalker.travel.home.HorizontalPagerWithOffsetTransition
import com.cyberwalker.travel.splash.SplashScreenActions
import com.cyberwalker.travel.ui.theme.*

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onAction: (actions: DetailScreenActions) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState
    ) { innerPadding ->
        DetailScreenContent(modifier = Modifier.padding(innerPadding), onAction = onAction)
    }
}

@Composable
private fun DetailScreenContent(
    modifier: Modifier,
    onAction: (actions: DetailScreenActions) -> Unit
) {
    Column(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 56.dp)
            .fillMaxHeight()
            .semantics { contentDescription = "Detail Screen" }
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_detail),
            contentDescription = null,
            modifier = Modifier.clip(
                RoundedCornerShape(10.dp)
            )
        )
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Lalakhal", style = MaterialTheme.typography.H2)
            Spacer(modifier = Modifier.weight(1F))
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                Modifier.size(10.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "(4.8)", style = MaterialTheme.typography.captionDefault)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "To journey from place to place or to a distant place. To get around pass from one place to another the news traveled fast.",
            style = MaterialTheme.typography.body,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        MoreImages()
        Spacer(modifier = Modifier.weight(1F))
        Row(Modifier.fillMaxWidth()) {
            Column {
                Text(text = "Total Price", style = MaterialTheme.typography.H3)
                Spacer(modifier = Modifier.size(12.dp))
                Row {
                    Text(text = "₹", style = MaterialTheme.typography.currency)
                    Text(text = "3435", style = MaterialTheme.typography.price)
                }
            }
            Spacer(modifier = Modifier.weight(1F))
            Button(
                onClick = {},
                modifier = Modifier.padding(bottom = 56.dp).size(170.dp, 56.dp),
                shape = RoundedCornerShape(72.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = ButtonColor2
                )
            ) {
                Text(text = "Book Now", style = MaterialTheme.typography.buttonText)
            }
        }
    }
}

@Composable
private fun MoreImages() {
    Spacer(modifier = Modifier.size(24.dp))
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)) {
        Text(text = "More Images", style = MaterialTheme.typography.bodyBold)
        Spacer(modifier = Modifier.size(16.dp))
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(id = R.drawable.more_1),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.more_2),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.more_3),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.more_4),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
        }
    }
}


sealed class DetailScreenActions {
    object Back : DetailScreenActions()
}