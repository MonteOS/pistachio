package com.monte.os.pistachio.main.component.item

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monte.os.identifier.Item

@Composable
fun ItemsList(
    list: List<Item>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        list.forEach { item ->
            item {
                ItemUi(
                    modifier = Modifier
                        .padding(12.dp),
                    name = item.name,
                    value = item.value
                )
            }
        }
    }
}
