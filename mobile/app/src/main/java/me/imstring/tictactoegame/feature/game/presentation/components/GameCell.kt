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
import androidx.compose.ui.graphics.Color
import me.imstring.tictactoegame.feature.game.domain.model.Mark
import me.imstring.tictactoegame.ui.icons.OIcon
import me.imstring.tictactoegame.ui.icons.XIcon

@Composable
fun GameCell(
    mark: Mark?,
    onClick: () -> Unit
) {
    val backgroundColor = when (mark) {
        Mark.X -> Color(0x332475C5)
        Mark.O -> Color(0x33E45651)
        null -> Color.Transparent
    }

    val borderColor = when (mark) {
        Mark.X -> Color(0xFF2475C5)
        Mark.O -> Color(0xFFE45651)
        null -> Color(0xFF212835)
    }

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