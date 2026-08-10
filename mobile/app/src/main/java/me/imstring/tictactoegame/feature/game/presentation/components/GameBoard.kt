package me.imstring.tictactoegame.feature.game.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.imstring.tictactoegame.feature.game.domain.model.Mark

@Composable
fun GameBoard(
    board: List<Mark?>,
    onCellClick: (Int) -> Unit
) {
    for (row in 0..2) {
        Row(
            modifier = Modifier.padding(top = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (column in 0..2) {
                val index = row * 3 + column

                GameCell(
                    mark = board[index],
                    onClick = {
                        onCellClick(index)
                    }
                )
            }
        }
    }
}