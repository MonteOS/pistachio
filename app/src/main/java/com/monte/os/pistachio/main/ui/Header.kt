package com.monte.os.pistachio.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monte.os.pistachio.design.text.JustText
import com.monte.os.pistachio.design.text.SingleText

@Composable
fun Header(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onBackground
        )
        SingleText(
            modifier = Modifier
                .padding(16.dp),
            text = JustText(
                text = name,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
