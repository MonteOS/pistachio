package com.monte.os.pistachio.main.component.item

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.monte.os.pistachio.R
import com.monte.os.pistachio.design.text.JustText
import com.monte.os.pistachio.design.text.SingleText

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
            ItemsList(
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
