package me.imstring.tictactoegame.feature.game.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlayAgainButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFF808080)
        ),
        shape = RectangleShape
    ) {
        Icon(
            imageVector = Icons.Default.Refresh,
            tint = Color(0xFFADADAD),
            contentDescription = "Jogar novamente"
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Jogar Novamente",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFFADADAD)
        )
    }
}