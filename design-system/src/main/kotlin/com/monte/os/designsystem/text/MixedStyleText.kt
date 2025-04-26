package com.monte.os.designsystem.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString

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
