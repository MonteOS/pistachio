package com.monte.os.pistachio.design.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.monte.os.pistachio.design.theme.color.backgroundDark
import com.monte.os.pistachio.design.theme.color.backgroundLight
import com.monte.os.pistachio.design.theme.color.errorContainerDark
import com.monte.os.pistachio.design.theme.color.errorContainerLight
import com.monte.os.pistachio.design.theme.color.errorDark
import com.monte.os.pistachio.design.theme.color.errorLight
import com.monte.os.pistachio.design.theme.color.onBackgroundDark
import com.monte.os.pistachio.design.theme.color.onBackgroundLight
import com.monte.os.pistachio.design.theme.color.onErrorContainerDark
import com.monte.os.pistachio.design.theme.color.onErrorContainerLight
import com.monte.os.pistachio.design.theme.color.onErrorDark
import com.monte.os.pistachio.design.theme.color.onErrorLight
import com.monte.os.pistachio.design.theme.color.onPrimaryContainerDark
import com.monte.os.pistachio.design.theme.color.onPrimaryContainerLight
import com.monte.os.pistachio.design.theme.color.onPrimaryDark
import com.monte.os.pistachio.design.theme.color.onPrimaryLight
import com.monte.os.pistachio.design.theme.color.onSecondaryContainerDark
import com.monte.os.pistachio.design.theme.color.onSecondaryContainerLight
import com.monte.os.pistachio.design.theme.color.onSecondaryDark
import com.monte.os.pistachio.design.theme.color.onSecondaryLight
import com.monte.os.pistachio.design.theme.color.onTertiaryContainerDark
import com.monte.os.pistachio.design.theme.color.onTertiaryContainerLight
import com.monte.os.pistachio.design.theme.color.onTertiaryDark
import com.monte.os.pistachio.design.theme.color.onTertiaryLight
import com.monte.os.pistachio.design.theme.color.primaryContainerDark
import com.monte.os.pistachio.design.theme.color.primaryContainerLight
import com.monte.os.pistachio.design.theme.color.primaryDark
import com.monte.os.pistachio.design.theme.color.primaryLight
import com.monte.os.pistachio.design.theme.color.secondaryContainerDark
import com.monte.os.pistachio.design.theme.color.secondaryContainerLight
import com.monte.os.pistachio.design.theme.color.secondaryDark
import com.monte.os.pistachio.design.theme.color.secondaryLight
import com.monte.os.pistachio.design.theme.color.tertiaryContainerDark
import com.monte.os.pistachio.design.theme.color.tertiaryContainerLight
import com.monte.os.pistachio.design.theme.color.tertiaryDark
import com.monte.os.pistachio.design.theme.color.tertiaryLight


internal val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
)

internal val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
)
