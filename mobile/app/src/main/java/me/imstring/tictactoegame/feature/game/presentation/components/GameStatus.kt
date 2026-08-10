package me.imstring.tictactoegame.feature.game.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.imstring.tictactoegame.feature.game.domain.model.Mark

@Composable
fun GameStatus(
    currentPlayer: Mark,
    winner: Mark?,
    isDraw: Boolean
) {
    when {
        winner != null -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val winPlayerText = when (currentPlayer) {
                    Mark.X -> "O X"
                    Mark.O -> "A bolinha"
                }

                val winPlayerColor = when (currentPlayer) {
                    Mark.X -> Color(0xFF2475C5)
                    Mark.O -> Color(0xFFE45651)
                }

                Text(
                    text = "$winPlayerText ganhou!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = winPlayerColor
                )

                Text(
                    text = "Parabéns",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFADADAD)
                )
            }
        }

        isDraw -> {
            Text(
                text = "EMPATE!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFADADAD)
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
                color = Color(0xFFADADAD)
            )
        }
    }
}