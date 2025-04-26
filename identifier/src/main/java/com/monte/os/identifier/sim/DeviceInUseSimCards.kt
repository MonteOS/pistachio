package com.monte.os.identifier.sim

import android.content.Context
import android.telephony.TelephonyManager
import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import com.monte.os.identifier.R
import com.monte.os.identifier.props.Property

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
        val networkType = Property
            .get("gsm.network.type")
            .substringBefore(",")

        return listOf(
            Item("Carrier ID", telephony.simCarrierId.toString()),
            Item("Operator Name", telephony.simOperatorName),
            Item("Operator Code", telephony.simOperator),
            Item("Country Code", countryCode),
            Item("Country", simCountryIso),
            Item("Network Type", networkType),
        )
    }
}
