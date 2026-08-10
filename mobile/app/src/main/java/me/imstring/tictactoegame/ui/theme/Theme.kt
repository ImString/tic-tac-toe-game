package me.imstring.tictactoegame.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = DarkBlue,
    onPrimary = NeutralWhite,
    primaryContainer = DarkDarkBlue,
    onPrimaryContainer = NeutralWhite,

    secondary = DarkGreen,
    onSecondary = DarkDark,
    secondaryContainer = DarkDarkBlue,
    onSecondaryContainer = NeutralWhite,

    tertiary = DarkRed,
    onTertiary = DarkDark,
    tertiaryContainer = DarkDarkBlue,
    onTertiaryContainer = NeutralWhite,

    error = DarkRed,
    onError = DarkDark,

    background = DarkDark,
    onBackground = Gray,

    surface = DarkDarkerBlue,
    onSurface = Gray,

    surfaceVariant = DarkDarkBlue,
    onSurfaceVariant = Gray,

    outline = DarkGray,
    outlineVariant = DarkerGray
)

private val LightColorScheme = lightColorScheme(
    primary = LightBlue,
    onPrimary = Black,
    primaryContainer = LighterGray,
    onPrimaryContainer = DarkestGray,

    secondary = LightGreen,
    onSecondary = Black,
    secondaryContainer = LighterGray,
    onSecondaryContainer = DarkestGray,

    tertiary = LightRed,
    onTertiary = Black,
    tertiaryContainer = LighterGray,
    onTertiaryContainer = DarkestGray,

    error = LightRed,
    onError = Black,

    background = NeutralWhite,
    onBackground = DarkestGray,

    surface = LighterGray,
    onSurface = DarkestGray,

    surfaceVariant = LightGray,
    onSurfaceVariant = DarkerGray,

    outline = DarkGray,
    outlineVariant = LightGray
)

@Composable
fun TicTacToeGameTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}