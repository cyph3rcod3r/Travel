/*
 * Copyright 2021 The Android Open Source Project
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
package com.cyberwalker.travel.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberwalker.travel.R
import com.cyberwalker.travel.ui.theme.ButtonColor
import com.cyberwalker.travel.ui.theme.ButtonColor2
import com.cyberwalker.travel.ui.theme.buttonText

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onAction: (actions: SplashScreenActions) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState
    ) { innerPadding ->
        SplashScreenContent(modifier = Modifier.padding(innerPadding), onAction = onAction)
    }
}

@Composable
private fun SplashScreenContent(
    modifier: Modifier,
    onAction: (actions: SplashScreenActions) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = com.cyberwalker.travel.R.drawable.img_splash),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Button(
            onClick = { onAction(SplashScreenActions.LoadHome) },
            modifier = Modifier.padding(bottom = 56.dp).size(220.dp, 76.dp).align(Alignment.BottomCenter),
            shape = RoundedCornerShape(72.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ButtonColor2
            )
        ) {
            Text(text = "Let's Start", style = MaterialTheme.typography.buttonText)
            Spacer(modifier = Modifier.size(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

sealed class SplashScreenActions {
    object LoadHome : SplashScreenActions()
}