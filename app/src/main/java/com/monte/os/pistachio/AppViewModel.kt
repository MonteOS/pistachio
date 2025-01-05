package com.monte.os.pistachio

import com.monte.os.pistachio.identifiers.BuildIdentifiers
import com.monte.os.pistachio.identifiers.DeviceIdentifiers
import com.monte.os.pistachio.identifiers.DisplayIdentifiers
import com.monte.os.pistachio.identifiers.SimIdentifiers
import com.monte.os.pistachio.identifiers.SystemIdentifiers
import com.monte.os.pistachio.identifiers.TimeAndDateIdentifiers
import com.monte.os.pistachio.ui.BaseViewModel
import com.monte.os.pistachio.ui.DispatchersList
import com.monte.os.pistachio.ui.HeaderWithPairs
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
