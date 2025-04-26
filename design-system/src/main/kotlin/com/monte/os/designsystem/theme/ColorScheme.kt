package com.monte.os.designsystem.theme

import androidx.compose.material3.lightColorScheme
import com.monte.os.designsystem.theme.color.backgroundLight
import com.monte.os.designsystem.theme.color.errorContainerLight
import com.monte.os.designsystem.theme.color.errorLight
import com.monte.os.designsystem.theme.color.onBackgroundLight
import com.monte.os.designsystem.theme.color.onErrorContainerLight
import com.monte.os.designsystem.theme.color.onErrorLight
import com.monte.os.designsystem.theme.color.onPrimaryContainerLight
import com.monte.os.designsystem.theme.color.onPrimaryLight
import com.monte.os.designsystem.theme.color.onSecondaryContainerLight
import com.monte.os.designsystem.theme.color.onSecondaryLight
import com.monte.os.designsystem.theme.color.onTertiaryContainerLight
import com.monte.os.designsystem.theme.color.onTertiaryLight
import com.monte.os.designsystem.theme.color.primaryContainerLight
import com.monte.os.designsystem.theme.color.primaryLight
import com.monte.os.designsystem.theme.color.secondaryContainerLight
import com.monte.os.designsystem.theme.color.secondaryLight
import com.monte.os.designsystem.theme.color.tertiaryContainerLight
import com.monte.os.designsystem.theme.color.tertiaryLight

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
