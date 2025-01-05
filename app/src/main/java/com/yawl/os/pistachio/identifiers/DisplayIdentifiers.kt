package com.yawl.os.pistachio.identifiers

import com.yawl.os.pistachio.identifiers.screen.ScreenRepository
import javax.inject.Inject

interface DisplayIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val repository: ScreenRepository
    ) : DisplayIdentifiers {
        override fun list(): List<Pair<String, String>> {
            return listOf(
                "Resolution" to repository.resolution(),
                "Ratio" to repository.ratio(),
                "Density" to repository.density(),
                "X DPI" to repository.xDPI(),
                "Y DPI" to repository.yDPI(),
                "Refresh rate" to repository.refreshRate(),
                "Modes" to repository.modes(),
            )
        }
    }
}
