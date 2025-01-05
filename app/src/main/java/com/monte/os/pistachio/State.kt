package com.monte.os.pistachio

import com.monte.os.pistachio.ui.HeaderWithPairs

interface State {

    object Loading: State

    data class Success(
        val data: List<HeaderWithPairs>
    ): State

}