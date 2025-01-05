package com.monte.os.pistachio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.monte.os.pistachio.ui.ListWithHeaders
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Activity : ComponentActivity() {

    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.load()
        setContent {
            val state by viewModel
                .state()
                .collectAsStateWithLifecycle()
            Scaffold { innerPadding ->
                Ui(
                    state = state,
                    modifier = Modifier.padding(
                        innerPadding
                    )
                )
            }
        }
    }
}

@Composable
fun Ui(
    state: State,
    modifier: Modifier = Modifier
) {
    when (state) {
        is State.Loading -> {
            Box(
                modifier = modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is State.Success -> {
            ListWithHeaders(
                sections = state.data,
                modifier = modifier
            )
        }
    }
}
