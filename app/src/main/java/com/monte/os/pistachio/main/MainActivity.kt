package com.monte.os.pistachio.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.monte.os.designsystem.theme.ApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            viewModel.reload()

            val state by viewModel
                .state
                .collectAsStateWithLifecycle()

            ApplicationTheme {
                Scaffold { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(
                            paddingValues = innerPadding
                        ),
                        list = state
                    )
                }
            }
        }
    }
}
