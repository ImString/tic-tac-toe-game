package me.imstring.tictactoegame.feature.game.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                    style = MaterialTheme.typography.titleLarge,
                    color = winnerColor
                )

                Text(
                    text = "Parabéns",
                    style = MaterialTheme.typography.titleMedium,
                    color = neutralContentColor
                )
            }
        }

        isDraw -> {
            Text(
                text = "EMPATE!",
                style = MaterialTheme.typography.titleLarge,
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
                style = MaterialTheme.typography.titleLarge,
                color = neutralContentColor
            )
        }
    }
}
