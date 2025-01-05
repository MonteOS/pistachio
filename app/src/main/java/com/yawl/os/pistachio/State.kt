package com.yawl.os.pistachio

import com.yawl.os.pistachio.ui.HeaderWithPairs

interface State {

    object Loading: State

    data class Success(
        val data: List<HeaderWithPairs>
    ): State

}