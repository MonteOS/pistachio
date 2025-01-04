package com.yawl.os.pistachio.screen

import android.content.Context
import android.view.WindowManager

class Screen(
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
        return ""
    }

    override fun xDPI(): String {
        return ""
    }

    override fun yDPI(): String {
        return ""
    }

    override fun ppi(): String {
        return ""
    }

    override fun refreshRate(): String {
        return ""
    }

    override fun modes(): String {
        return ""
    }
}