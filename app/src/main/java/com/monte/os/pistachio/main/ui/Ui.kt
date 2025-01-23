package com.monte.os.pistachio.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.monte.os.identifier.Section

@Composable
fun Screen(
    data: List<Section>,
    modifier: Modifier = Modifier
) {
    if (data.isEmpty()) {
        Loading(
            modifier = modifier
                .fillMaxSize()
        )
    } else {
        Identifiers(
            modifier = modifier,
            data = data
        )
    }
}

@Composable
fun Loading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun Identifiers(
    data: List<Section>,
    modifier: Modifier = Modifier
) {
    List(
        modifier = modifier,
        data = data
    )
}
