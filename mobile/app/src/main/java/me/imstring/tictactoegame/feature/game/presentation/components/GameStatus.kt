package me.imstring.tictactoegame.feature.game.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.imstring.tictactoegame.feature.game.domain.model.Mark

@Composable
fun GameStatus(
    currentPlayer: Mark,
    winner: Mark?,
    isDraw: Boolean
) {
    val neutralContentColor = MaterialTheme.colorScheme.onBackground

    when {
        winner != null -> {
            val winnerText = when (winner) {
                Mark.X -> "O X"
                Mark.O -> "A bolinha"
            }

            val winnerColor = when (winner) {
                Mark.X -> MaterialTheme.colorScheme.primary
                Mark.O -> MaterialTheme.colorScheme.tertiary
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$winnerText ganhou!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = winnerColor
                )

                Text(
                    text = "Parabéns",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = neutralContentColor
                )
            }
        }

        isDraw -> {
            Text(
                text = "EMPATE!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = neutralContentColor
            )
        }

        else -> {
            val playerText = when (currentPlayer) {
                Mark.X -> "do X"
                Mark.O -> "da bolinha"
            }

            Text(
                text = "Vez $playerText",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = neutralContentColor
            )
        }
    }
}
