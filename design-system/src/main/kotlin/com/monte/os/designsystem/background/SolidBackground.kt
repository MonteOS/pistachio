package com.monte.os.pistachio.design.background

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor


@Composable
fun solidBackground(color: Color): Brush {
    return remember(color) {
        SolidColor(value = color)
    }
}
