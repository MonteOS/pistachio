package com.yawl.os.pistachio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.yawl.os.pistachio.ui.ListWithHeaders
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Activity : ComponentActivity() {

    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold { innerPadding ->
                val list = viewModel.identifiers()
                ListWithHeaders(
                    sections = list,
                    modifier = Modifier.padding(
                        innerPadding
                    )
                )
            }
        }
    }
}
