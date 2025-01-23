package com.monte.os.pistachio.core

import kotlinx.coroutines.Job

interface Handle {
    fun <T : Any> async(
        block: suspend () -> T,
        ui: (T) -> Unit
    ): Job

    fun <T : Any> async(
        block: suspend () -> T,
    ): Job
}
