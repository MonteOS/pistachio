package com.yawl.os.pistachio.identifiers.screen

import android.content.Context
import android.view.WindowManager
import javax.inject.Inject
import kotlin.math.roundToInt

class ScreenInfo @Inject constructor(
    private val context: Context
): ScreenRepository {

    override fun resolution(): String {
        val service = context.getSystemService(
            Context.WINDOW_SERVICE
        ) as WindowManager
        val bounds = service
            .currentWindowMetrics
            .bounds
        val width = bounds.width()
        val height = bounds.height()
        return "$height $width"
    }

    override fun ratio(): String {
        return ""
    }

    override fun diagonal(): String {
        return ""
    }

    override fun size(): String {
        return ""
    }

    override fun density(): String {
        return "${context.resources.displayMetrics.densityDpi} dpi"
    }

    override fun xDPI(): String {
        return "${context.resources.displayMetrics.xdpi} dpi"
    }

    override fun yDPI(): String {
        return "${context.resources.displayMetrics.ydpi} dpi"
    }

    override fun ppi(): String {
        return "${context.resources.displayMetrics.xdpi} dpi"
    }

    override fun refreshRate(): String {
        val service = context.getSystemService(
            Context.WINDOW_SERVICE
        ) as WindowManager
        return "${service.defaultDisplay.refreshRate.roundToInt()} Hz"
    }

    override fun modes(): String {
        return ""
    }
}