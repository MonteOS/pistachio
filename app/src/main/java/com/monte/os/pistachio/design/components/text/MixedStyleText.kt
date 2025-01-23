package com.monte.os.pistachio.design.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import com.monte.os.pistachio.design.atom.text.TextAtom


@Composable
fun MixedStyleText(
    vararg parts: TextAtom,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            parts.forEach { part ->
                part.AnnotatedString(this)
            }
        }
    )
}
