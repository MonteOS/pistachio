package com.monte.os.designsystem.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun SingleText(
    text: TextAtom,
    modifier: Modifier = Modifier,
) {
    MixedStyleText(
        parts = arrayOf(text),
        modifier = modifier
    )
}
