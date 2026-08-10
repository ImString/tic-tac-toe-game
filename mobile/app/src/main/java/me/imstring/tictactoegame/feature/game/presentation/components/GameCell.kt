package me.imstring.tictactoegame.feature.game.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import me.imstring.tictactoegame.feature.game.domain.model.Mark
import me.imstring.tictactoegame.ui.icons.OIcon
import me.imstring.tictactoegame.ui.icons.XIcon

@Composable
fun GameCell(
    mark: Mark?,
    onClick: () -> Unit
) {
    val markColor = when (mark) {
        Mark.X -> MaterialTheme.colorScheme.primary
        Mark.O -> MaterialTheme.colorScheme.tertiary
        null -> null
    }

    val backgroundColor = when (mark) {
        null -> MaterialTheme.colorScheme.surface
        else -> markColor!!.copy(alpha = 0.20f)
    }

    val borderColor = markColor ?: MaterialTheme.colorScheme.outlineVariant

    val icon = when (mark) {
        Mark.X -> XIcon
        Mark.O -> OIcon
        null -> null
    }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
        ),
        modifier = Modifier
            .padding(end = 14.dp)
            .size(80.dp),
        border = BorderStroke(width = 1.dp, color = borderColor),
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        if (icon != null)
            Icon(
                imageVector = icon,
                contentDescription = mark?.name ?: "Não selecionado",
                modifier = Modifier.size(28.dp),
                tint = borderColor
            )
    }
}