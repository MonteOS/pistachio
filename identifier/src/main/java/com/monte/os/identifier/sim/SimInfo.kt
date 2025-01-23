package com.monte.os.identifier.sim

import android.content.Context
import android.telephony.TelephonyManager
import com.monte.os.identifier.R
import javax.inject.Inject

class SimInfo @Inject constructor(
    private val context: Context
) : ProvideSIM {
    override fun sim(): List<PhoneSIM> {
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
            PhoneSIM(
                operatorName = telephony.simOperatorName,
                operatorCode = telephony.simOperator,
                country = simCountryIso,
                countryCode = countryCode
            )
        )
    }
}
