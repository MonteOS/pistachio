package com.monte.os.pistachio.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.monte.os.designsystem.text.JustText
import com.monte.os.designsystem.text.SingleText
import com.monte.os.pistachio.R
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

    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Header()
        SectionsList(
            list = list,
            onClick = { index ->
                selected = index
            }
        )
    }

    selected?.let { index ->
        val selectedSection = list[index]
        ItemsDialog(
            title = selectedSection.title,
            items = selectedSection.items,
            onDismiss = { selected = null }
        )
    }
}

@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SingleText(
            text = JustText(
                text = stringResource(
                    id = R.string.monteos_privacy_check
                ),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
        )
    }
}