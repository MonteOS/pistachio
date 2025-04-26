package com.monte.os.designsystem.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.withStyle

import com.monte.os.designsystem.background.solidBackground

interface TextAtom {
    @Composable
    fun AnnotatedString(builder: AnnotatedString.Builder)
}

class JustText(
    private val text: String,
    private val style: TextStyle,
    private val color: Color
) : TextAtom {
    @Composable
    override fun AnnotatedString(
        builder: AnnotatedString.Builder
    ) {
        builder.apply {
            withStyle(
                style = style.toSpanStyle().copy(
                    brush = solidBackground(
                        color = color
                    )
                )
            ) {
                append(text)
            }
        }
    }
}
