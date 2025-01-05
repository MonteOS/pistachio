package com.yawl.os.pistachio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.yawl.os.pistachio.appscope.AppScopeInfo
import com.yawl.os.pistachio.core.Property
import com.yawl.os.pistachio.screen.ScreenInfo
import com.yawl.os.pistachio.sim.SimInfo
import com.yawl.os.pistachio.system.SystemInfo
import com.yawl.os.pistachio.ui.List

class Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold { innerPadding ->
                val property = Property()
                val general = SystemInfo(property)
                val screen = ScreenInfo(this)
                val appScope = AppScopeInfo(this)
                val sim = SimInfo(this)
                val pairs = listOf(
                    "SIM" to sim.sim().toString(),
                    "Android ID" to appScope.androidId(),
                    "Resolution" to screen.resolution(),
                    "Ratio" to screen.ratio(),
                    "Density" to screen.density(),
                    "X DPI" to screen.xDPI(),
                    "Y DPI" to screen.yDPI(),
                    "Refresh rate" to screen.refreshRate(),
                    "Modes" to screen.modes(),
                    "Manufacturer" to general.manufacturer(),
                    "Brand" to general.brand(),
                    "Model" to general.model(),
                    "Release" to general.release(),
                    "API" to general.api(),
                    "Device" to general.device(),
                    "Product" to general.product(),
                    "Board" to general.board(),
                    "Platform" to general.platform(),
                    "Build" to general.build(),
                    "Java VM" to general.javaVM(),
                    "Security" to general.security(),
                    "Kernel" to general.kernelVersion(),
                    "Baseband" to general.baseband(),
                    "Build Type" to general.buildType(),
                    "Tags" to general.tags(),
                    "Incremental" to general.incremental(),
                    "Description" to general.description(),
                    "Fingerprint" to general.fingerprint(),
                    "Build Date" to general.buildDate(),
                    "Builder" to general.builder(),
                    "Language" to general.language(),
                    "Timezone" to general.timezone()
                )
                List(
                    pairs = pairs,
                    modifier = Modifier.padding(
                        innerPadding
                    )
                )
            }
        }
    }
}
