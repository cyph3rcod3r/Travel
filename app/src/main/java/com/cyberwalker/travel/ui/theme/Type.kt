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
package com.cyberwalker.travel.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cyberwalker.travel.R

val gilroy = FontFamily(Font(R.font.gilroy, FontWeight.Normal), Font(R.font.gilroy_bold, FontWeight.Bold))



val Typography.buttonText: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
        color = Color.White
    )

val Typography.captionDefault: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        color = Color(0xFF73848C)
    )

val Typography.H1: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
        color = Color(0xFF452933)
    )


val Typography.body: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        color = Color(0xFF73848C)
    )

val Typography.bodyBold: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W700,
        fontSize = 14.sp,
        color = Color(0xFF452933)
    )

val Typography.H2: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
        color = Color(0xFF452933)
    )

val Typography.H3: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        color = Color(0xFF201E1E)
    )

val Typography.price: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp,
        color = Color(0xFF452933)
    )

val Typography.currency: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        color = ButtonColor2
    )


val Typography.search: TextStyle
    get() = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
        color = Color(0x8073848C)
    )

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
)