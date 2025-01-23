package com.monte.os.pistachio.main

import androidx.lifecycle.viewModelScope
import com.monte.os.identifier.PhoneIdentifiers
import com.monte.os.pistachio.core.BaseViewModel
import com.monte.os.pistachio.core.DispatchersList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val identifiers: PhoneIdentifiers,
    dispatchersList: DispatchersList
) : BaseViewModel(dispatchersList) {

    val state = identifiers
        .data()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    fun reload() = async { identifiers.reload() }
}
