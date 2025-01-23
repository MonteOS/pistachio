package com.monte.os.pistachio.main.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.monte.os.pistachio.R
import com.monte.os.pistachio.design.text.JustText
import com.monte.os.pistachio.design.text.SingleText
import com.monte.os.pistachio.main.model.Item
import com.monte.os.pistachio.main.model.Section

@Composable
fun Screen(
    list: List<Section>,
    modifier: Modifier = Modifier
) {
    var selected by rememberSaveable {
        mutableStateOf<Int?>(null)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        list.forEachIndexed { index, section ->
            item {
                SectionUi(
                    section = section,
                    onClick = {
                        selected = index
                    }
                )
            }
        }
    }

    selected?.let { index ->
        val selectedSection = list[index]
        ItemsDialog(
            title = stringResource(
                id = selectedSection.title
            ),
            items = selectedSection.items,
            onDismiss = { selected = null }
        )
    }
}

@Composable
fun ItemsDialog(
    title: String,
    items: List<Item>,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        title = {
            SingleText(
                text = JustText(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        text = {
            Items(
                list = items
            )
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                SingleText(
                    text = JustText(
                        text = stringResource(R.string.ok_button),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )
            }
        }
    )
}

@Composable
fun Items(
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
