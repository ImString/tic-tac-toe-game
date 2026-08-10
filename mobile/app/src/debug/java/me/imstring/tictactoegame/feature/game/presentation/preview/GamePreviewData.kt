package me.imstring.tictactoegame.feature.game.presentation.preview

import me.imstring.tictactoegame.feature.game.domain.model.GameState
import me.imstring.tictactoegame.feature.game.domain.model.Mark

internal object GamePreviewData {
    val initial = GameState()

    val xWinner = GameState(
        board = listOf(
            Mark.X, Mark.X, Mark.X,
            Mark.O, Mark.O, null,
            null, null, null
        ),
        currentPlayer = Mark.X,
        winner = Mark.X
    )

    val oWinner = GameState(
        board = listOf(
            Mark.O, Mark.O, Mark.O,
            Mark.X, Mark.X, null,
            Mark.X, null, null
        ),
        currentPlayer = Mark.O,
        winner = Mark.O
    )

    val draw = GameState(
        board = listOf(
            Mark.X, Mark.O, Mark.X,
            Mark.X, Mark.O, Mark.O,
            Mark.O, Mark.X, Mark.X
        ),
        currentPlayer = Mark.X,
        isDraw = true
    )
}
