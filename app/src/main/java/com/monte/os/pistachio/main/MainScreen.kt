package com.monte.os.pistachio.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.monte.os.pistachio.main.component.item.ItemsDialog
import com.monte.os.pistachio.main.component.section.Section
import com.monte.os.pistachio.main.component.section.SectionsList

@Composable
fun MainScreen(
    list: List<Section>,
    modifier: Modifier = Modifier
) {
    var selected by rememberSaveable {
        mutableStateOf<Int?>(null)
    }

    SectionsList(
        modifier = modifier
            .fillMaxSize(),
        list = list,
        onClick = { index ->
            selected = index
        }
    )

    selected?.let { index ->
        val selectedSection = list[index]
        ItemsDialog(
            title = selectedSection.title,
            items = selectedSection.items,
            onDismiss = { selected = null }
        )
    }
}
