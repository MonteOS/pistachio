package com.monte.os.identifier.sim

import android.content.Context
import android.telephony.TelephonyManager
import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import com.monte.os.identifier.R

class DeviceInUseSimCards(
    private val context: Context
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        val telephony = context.getSystemService(
            Context.TELEPHONY_SERVICE
        ) as TelephonyManager
        val simCountryIso = telephony.simCountryIso.uppercase()
        val countryCode = context
            .resources
            .getStringArray(R.array.country_code)
            .map { it.split(",") }
            .find { it[1] == simCountryIso }
            ?.firstOrNull() ?: ""

        return listOf(
            Item("Operator Name", telephony.simOperatorName),
            Item("Operator Code", telephony.simOperator),
            Item("Carrier ID", telephony.simCarrierId.toString()),
            Item("Country Code", countryCode),
            Item("Country", simCountryIso),
        )
    }
}
