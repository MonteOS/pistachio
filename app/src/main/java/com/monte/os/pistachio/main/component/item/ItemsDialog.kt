package com.monte.os.pistachio.main.component.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monte.os.identifier.Item
import com.monte.os.pistachio.design.text.JustText
import com.monte.os.pistachio.design.text.SingleText
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsDialog(
    title: String,
    items: List<Item>,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = {
            coroutineScope.launch {
                bottomSheetState.hide()
            }
            onDismiss()
        },
        containerColor = MaterialTheme.colorScheme.background,
        sheetState = bottomSheetState,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                title = title
            )
            ItemsList(
                list = items
            )
        }
    }
}

@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier
) {
    SingleText(
        modifier = modifier,
        text = JustText(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
    )
}