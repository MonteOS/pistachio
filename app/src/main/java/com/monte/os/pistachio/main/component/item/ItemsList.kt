package com.monte.os.pistachio.main.component.item

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            item(
                key = { item.name }
            ) {
                ItemUi(
                    name = item.name,
                    value = item.value
                )
            }
        }
    }
}
