package com.monte.os.pistachio.main.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Section(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val icon: Int,
    val items: List<Item>
)
