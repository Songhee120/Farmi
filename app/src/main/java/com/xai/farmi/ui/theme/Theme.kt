package com.xai.farmi.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// 색상 정의
val Green = Color(0xFFA5D6A7)
val Yellow = Color(0xFFFFEB99)
val Orange = Color(0xFFFFCC80)
val LightYellow = Color(0xFFFCFAEE)

val lightColors = lightColorScheme(
    primary = Green,
    secondary = Orange,
    background = LightYellow,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.DarkGray,
    onSurface = Color.Black
)

@Composable
fun FarmiTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColors,
        content = content
    )
}
