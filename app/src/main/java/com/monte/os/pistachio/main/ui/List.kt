package com.monte.os.pistachio.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monte.os.identifier.Section
import com.monte.os.identifier.SimpleItem

@Composable
fun List(
    data: List<Section>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        data.forEach { section ->
            item {
                Header(
                    name = section.name
                )
            }
            items(section.items.size) { index ->
                val item = section.items[index]
                val backgroundColor = if (index % 2 == 0) {
                    MaterialTheme.colorScheme.surfaceVariant
                } else {
                    MaterialTheme.colorScheme.surface
                }
                when (item) {
                    is SimpleItem -> {
                        Item(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(backgroundColor)
                                .padding(16.dp),
                            name = item.name,
                            value = item.value
                        )
                    }
                }
            }
        }
    }
}
