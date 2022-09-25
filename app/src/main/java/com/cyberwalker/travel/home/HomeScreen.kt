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
package com.cyberwalker.travel.home

import android.graphics.BlurMaskFilter
import android.graphics.Paint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cyberwalker.travel.R
import com.cyberwalker.travel.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue
import androidx.compose.ui.util.lerp

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onAction: (actions: HomeScreenActions) -> Unit,
    navController: NavHostController
) {
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            NavBar()
        },
    ) { innerPadding ->
        HomeScreenContent(modifier = Modifier.padding(innerPadding), onAction = onAction)
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier,
    onAction: (actions: HomeScreenActions) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .semantics { contentDescription = "Home Screen" }
    ) {
        Spacer(modifier = Modifier.size(56.dp))
        ToolbarHome()
        Header()
        Categories {
            onAction(HomeScreenActions.Details)
        }
        Spacer(modifier = Modifier.size(56.dp))
    }
}

@Composable
fun Header() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.home_main),
            contentDescription = null,
            modifier = Modifier
                .size(342.dp, 285.dp)
                .align(Alignment.Center),
        )

        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable { }
                .size(296.dp, 80.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Where to go", style = MaterialTheme.typography.search)
            Spacer(modifier = Modifier.weight(1F))
            Image(painter = painterResource(id = R.drawable.search), contentDescription = null)
        }
    }
}

@Composable
private fun NavBar() {
    val modifier = Modifier
        .padding(end = 24.dp)
        .fillMaxWidth()
        .defaultMinSize(minWidth = 327.dp, minHeight = 67.dp)
        .border(shape = RoundedCornerShape(12.dp), width = 1.dp, color = Color.Transparent)
    Box(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minWidth = 327.dp, minHeight = 67.dp)
                    .border(shape = RoundedCornerShape(12.dp), width = 1.dp, color = Color.Transparent)
                    .background(color = Color.Transparent, shape = RoundedCornerShape(12.dp))
            )
            Row(
                modifier = Modifier
                    .defaultMinSize(minWidth = 370.dp, minHeight = 67.dp),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Spacer(modifier = Modifier.size(16.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(y = (-8).dp)
                ) {
                    Spacer(
                        modifier = Modifier
                            .size(16.dp, 2.dp)
                            .background(actionColor, shape = RoundedCornerShape(2.dp))
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Image(
                        painter = painterResource(id = com.cyberwalker.travel.R.drawable.home),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                Icon(
                    painter = painterResource(id = com.cyberwalker.travel.R.drawable.ticket),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.size(104.dp))
                Icon(
                    painter = painterResource(id = com.cyberwalker.travel.R.drawable.saved),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Icon(
                    painter = painterResource(id = com.cyberwalker.travel.R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }

        Image(
            painter = painterResource(id = com.cyberwalker.travel.R.drawable.boat),
            contentDescription = null,
            modifier = Modifier
                .align(
                    Alignment.Center
                )
                .offset(y = (-24).dp)
        )
    }
}

@Composable
private fun ToolbarHome() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = com.cyberwalker.travel.R.drawable.home_profile),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text(text = "Welcome Home", style = MaterialTheme.typography.captionDefault)
            Text(text = "Niraj Manjhi", style = MaterialTheme.typography.H1)
        }
        Spacer(modifier = Modifier.weight(1F))
        Image(painter = painterResource(id = R.drawable.notification), contentDescription = null)
    }
}

@Composable
private fun Categories(onClick: () -> Unit) {
    Spacer(modifier = Modifier.size(24.dp))
    Column(Modifier.fillMaxWidth()) {
        Text(text = "Popular Categories", style = MaterialTheme.typography.H2)
        Spacer(modifier = Modifier.size(16.dp))
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Category(paint = R.drawable.cat_1, text = "Mountain")
            Category(paint = R.drawable.cat_2, text = "Adventure")
            Category(paint = R.drawable.cat_3, text = "Beach")
            Category(paint = R.drawable.cat_4, text = "City")
        }
        HorizontalPagerWithOffsetTransition(onClick = onClick)
    }
}

@Composable
fun Category(@DrawableRes paint: Int, text: String) {
    Column(
        modifier = Modifier.defaultMinSize(minWidth = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = paint),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = text, style = MaterialTheme.typography.captionDefault)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerWithOffsetTransition(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Spacer(modifier = Modifier.size(16.dp))
    Text(text = "Recommended", style = MaterialTheme.typography.H2)
    HorizontalPager(
        count = 3,
        // Add 32.dp horizontal padding to 'center' the pages
        contentPadding = PaddingValues(horizontal = 32.dp),
        modifier = modifier.fillMaxWidth()
    ) { page ->
        Box(
            Modifier
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    // We animate the scaleX + scaleY, between 85% and 100%
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            HorizontalPage(page = page, onClick = onClick)
        }
    }
}

@Composable
fun HorizontalPage(page: Int, onClick: () -> Unit) {
    Box(modifier = Modifier.clickable { onClick() }) {
        Image(
            painter = painterResource(id = mapOfPage[page].first),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        )
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth()
                .align(
                    Alignment.BottomStart
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = mapOfPage[page].second,
                style = MaterialTheme.typography.H1,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.size(8.dp))
            Image(painter = painterResource(id = R.drawable.star), contentDescription = null)
            Text(text = "(4.9)", style = MaterialTheme.typography.captionDefault)
            Spacer(modifier = Modifier.weight(1F))
            Text(text = "₹ 1942", style = MaterialTheme.typography.H2)
        }

    }
}

val mapOfPage = listOf(
    Pair(R.drawable.img_1, "Debtakhum"),
    Pair(R.drawable.img_2, "Sundarban"),
    Pair(R.drawable.img_3, "Chimbuk Hill"),
)

@Composable
private fun BlurBox(modifier: Modifier, alpha: Float = 0.2F, color: Color = ButtonColor) {
    val paint by remember {
        val value = Paint()
        value.maskFilter = BlurMaskFilter(12F, BlurMaskFilter.Blur.NORMAL)
        value.color = color.copy(alpha = alpha).toArgb()
        mutableStateOf(value)
    }

    Canvas(
        modifier = modifier
    ) {
        val width = size.width
        val height = size.height

        drawIntoCanvas {
            it.nativeCanvas.drawRect(0F, 0F, width, height, paint)
        }
    }
}


sealed class HomeScreenActions {
    object Details : HomeScreenActions()
}