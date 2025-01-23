package com.monte.os.pistachio.main

import com.monte.os.pistachio.main.ui.HeaderWithPairs

interface State {

    object Loading: State

    data class Success(
        val data: List<HeaderWithPairs>
    ): State

}