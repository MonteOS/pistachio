package com.monte.os.pistachio.main.model

import androidx.annotation.DrawableRes

data class Section(
    val title: String,
    val description: String,
    @DrawableRes val icon: Int,
    val items: List<Item>
)
