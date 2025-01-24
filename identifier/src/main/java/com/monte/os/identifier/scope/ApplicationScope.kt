package com.monte.os.identifier.scope

import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import javax.inject.Inject

class ApplicationScope @Inject constructor(
    private val repository: ApplicationScopeRepository
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
            Item("Installation date", repository.installationDate()),
            Item("Android ID", repository.androidId()),
            Item("User and group ID", repository.fullAppId()),
        )
    }
}