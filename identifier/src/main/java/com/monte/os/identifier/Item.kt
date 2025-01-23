package com.monte.os.identifier

interface Item {
    val name: String
}

data class SimpleItem(
    override val name: String,
    val value: String
) : Item

data class LongListItem(
    override val name: String,
    val values: List<SimpleItem>
) : Item
