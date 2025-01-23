package com.monte.os.pistachio.design.components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.monte.os.pistachio.design.atom.text.TextAtom


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
