package com.yawl.os.pistachio

import com.yawl.os.pistachio.identifiers.BuildIdentifiers
import com.yawl.os.pistachio.identifiers.DeviceIdentifiers
import com.yawl.os.pistachio.identifiers.DisplayIdentifiers
import com.yawl.os.pistachio.identifiers.SimIdentifiers
import com.yawl.os.pistachio.identifiers.SystemIdentifiers
import com.yawl.os.pistachio.identifiers.TimeAndDateIdentifiers
import com.yawl.os.pistachio.ui.BaseViewModel
import com.yawl.os.pistachio.ui.DispatchersList
import com.yawl.os.pistachio.ui.HeaderWithPairs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val system: SystemIdentifiers,
    private val build: BuildIdentifiers,
    private val device: DeviceIdentifiers,
    private val sim: SimIdentifiers,
    private val display: DisplayIdentifiers,
    private val timeAndDate: TimeAndDateIdentifiers,
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
                        header = "Device Identifiers",
                        data = device.list()
                    ),
                    HeaderWithPairs(
                        header = "SIM Identifiers",
                        data = sim.list()
                    ),
                    HeaderWithPairs(
                        header = "Build Identifiers",
                        data = build.list()
                    ),
                    HeaderWithPairs(
                        header = "System Identifiers",
                        data = system.list()
                    ),
                    HeaderWithPairs(
                        header = "Display Identifiers",
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
