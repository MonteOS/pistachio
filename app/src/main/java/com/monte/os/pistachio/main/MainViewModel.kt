package com.monte.os.pistachio.main

import androidx.lifecycle.viewModelScope
import com.monte.os.pistachio.core.BaseViewModel
import com.monte.os.pistachio.core.DispatchersList
import com.monte.os.pistachio.Phone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val identifiers: Phone,
    dispatchersList: DispatchersList
) : BaseViewModel(dispatchersList) {

    val state = identifiers
        .identifiers()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    fun reload() = async { identifiers.reload() }
}
