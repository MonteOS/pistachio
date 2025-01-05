package com.yawl.os.pistachio

import androidx.lifecycle.ViewModel
import com.yawl.os.pistachio.identifiers.appscope.AppScopeRepository
import com.yawl.os.pistachio.identifiers.drm.DrmRepository
import com.yawl.os.pistachio.identifiers.screen.ScreenRepository
import com.yawl.os.pistachio.identifiers.sim.SimRepository
import com.yawl.os.pistachio.identifiers.system.SystemRepository
import com.yawl.os.pistachio.ui.HeaderWithPairs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val system: SystemRepository,
    private val screen: ScreenRepository,
    private val sim: SimRepository,
    private val drm: DrmRepository,
    private val appScope: AppScopeRepository
) : ViewModel() {
    fun identifiers(): List<HeaderWithPairs> {
        val sim = sim.sim().first()
        return listOf(
            HeaderWithPairs(
                header = "Device Identifiers",
                data = listOf(
                    "DRM ID" to drm.drmId(),
                    "Android ID" to appScope.androidId(),
                )
            ),
            HeaderWithPairs(
                header = "SIM Identifiers",
                data = listOf(
                    "SIM operator name" to sim.operatorName,
                    "SIM operator code" to sim.operatorCode,
                    "SIM Country" to sim.country,
                    "SIM Country Code" to sim.countryCode,
                )
            ),
            HeaderWithPairs(
                header = "Device Specifications",
                data = listOf(
                    "Resolution" to screen.resolution(),
                    "Ratio" to screen.ratio(),
                    "Density" to screen.density(),
                    "X DPI" to screen.xDPI(),
                    "Y DPI" to screen.yDPI(),
                    "Refresh rate" to screen.refreshRate(),
                    "Modes" to screen.modes(),
                    "Manufacturer" to system.manufacturer(),
                    "Brand" to system.brand(),
                    "Model" to system.model(),
                    "Release" to system.release(),
                    "API" to system.api(),
                    "Device" to system.device(),
                    "Product" to system.product(),
                    "Board" to system.board(),
                    "Platform" to system.platform(),
                    "Build" to system.build(),
                    "Java VM" to system.javaVM(),
                    "Security" to system.security(),
                    "Kernel" to system.kernelVersion(),
                    "Baseband" to system.baseband(),
                    "Build Type" to system.buildType(),
                    "Tags" to system.tags(),
                    "Incremental" to system.incremental(),
                    "Description" to system.description(),
                    "Fingerprint" to system.fingerprint(),
                    "Build Date" to system.buildDate(),
                    "Builder" to system.builder(),
                    "Language" to system.language(),
                    "Timezone" to system.timezone()
                )
            )
        )
    }
}