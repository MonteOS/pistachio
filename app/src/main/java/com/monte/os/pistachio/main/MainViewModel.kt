package com.monte.os.pistachio.main

import com.monte.os.identifier.AppLifetimeScopeIdentifiers
import com.monte.os.identifier.BuildIdentifiers
import com.monte.os.identifier.DeviceIdentifiers
import com.monte.os.identifier.DisplayIdentifiers
import com.monte.os.identifier.DrmIdentifiers
import com.monte.os.identifier.SimIdentifiers
import com.monte.os.identifier.SystemIdentifiers
import com.monte.os.identifier.TimeAndDateIdentifiers
import com.monte.os.pistachio.main.ui.BaseViewModel
import com.monte.os.pistachio.main.ui.DispatchersList
import com.monte.os.pistachio.main.ui.HeaderWithPairs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val system: SystemIdentifiers,
    private val drm: DrmIdentifiers,
    private val build: BuildIdentifiers,
    private val device: DeviceIdentifiers,
    private val sim: SimIdentifiers,
    private val display: DisplayIdentifiers,
    private val timeAndDate: TimeAndDateIdentifiers,
    private val appScope: AppLifetimeScopeIdentifiers,
    dispatchersList: DispatchersList
) : BaseViewModel(dispatchersList) {

    private val state = MutableStateFlow<State>(
        value = State.Loading
    )

    fun state() = state

    fun load() {
        async {
            state.value = State.Success(
                data = listOf(
                    HeaderWithPairs(
                        header = "Pistachio Lifetime",
                        data = appScope.list()
                    ),
                    HeaderWithPairs(
                        header = "Device",
                        data = device.list()
                    ),
                    HeaderWithPairs(
                        header = "DRM",
                        data = drm.list()
                    ),
                    HeaderWithPairs(
                        header = "SIM",
                        data = sim.list()
                    ),
                    HeaderWithPairs(
                        header = "Build",
                        data = build.list()
                    ),
                    HeaderWithPairs(
                        header = "System",
                        data = system.list()
                    ),
                    HeaderWithPairs(
                        header = "Display",
                        data = display.list()
                    ),
                    HeaderWithPairs(
                        header = "Date & Time",
                        data = timeAndDate.list()
                    )
                )
            )
        }
    }
}
