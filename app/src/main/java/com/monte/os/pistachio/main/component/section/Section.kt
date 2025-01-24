package com.monte.os.pistachio.main.component.section

import androidx.annotation.DrawableRes
import com.monte.os.identifier.Item

data class Section(
    val title: String,
    val description: String,
    @DrawableRes val icon: Int,
    val items: List<Item>
) {
    fun notEmptyCount() = items.filter {
        it.value.isNotEmpty()
    }.size

    fun itemsCount() = items.size
}
