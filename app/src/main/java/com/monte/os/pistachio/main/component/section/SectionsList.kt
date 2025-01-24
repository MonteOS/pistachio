package com.monte.os.pistachio.main.component.section

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SectionsList(
    list: List<Section>,
    onClick: (index: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        list.forEachIndexed { index, section ->
            item {
                SectionUi(
                    section = section,
                    onClick = { onClick(index) }
                )
            }
        }
    }
}