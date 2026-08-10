package me.imstring.tictactoegame.feature.game.domain

import me.imstring.tictactoegame.feature.game.domain.model.GameState
import me.imstring.tictactoegame.feature.game.domain.model.Mark

object GameEngine {
    fun play(
        state: GameState,
        cellIndex: Int
    ): GameState {
        if (state.board[cellIndex] != null) {
            return state
        }

        val updatedBoard = state.board.toMutableList()

        updatedBoard[cellIndex] = state.currentPlayer

        val nextPlayer = when (state.currentPlayer) {
            Mark.X -> Mark.O
            Mark.O -> Mark.X
        }

        return state.copy(
            board = updatedBoard,
            currentPlayer = nextPlayer
        )
    }
}