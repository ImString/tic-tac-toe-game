package me.imstring.tictactoegame.feature.game.domain

import android.util.Log
import me.imstring.tictactoegame.feature.game.domain.model.GameState
import me.imstring.tictactoegame.feature.game.domain.model.Mark

object GameEngine {
    private val winningCombinations = listOf(
        listOf(0, 1, 2),
        listOf(3, 4, 5),
        listOf(6, 7, 8),

        listOf(0, 3, 6),
        listOf(1, 4, 7),
        listOf(2, 5, 8),

        listOf(0, 4, 8),
        listOf(2, 4, 6)
    )

    private fun checkWinner(
        board: List<Mark?>,
        player: Mark
    ): Boolean {
        return winningCombinations.any { combination ->
            combination.all { index ->
                board[index] == player
            }
        }
    }

    fun play(
        state: GameState,
        cellIndex: Int
    ): GameState {
        if (cellIndex !in state.board.indices) {
            return state
        }

        if (state.board[cellIndex] != null) {
            return state
        }

        if (state.winner != null || state.isDraw) {
            return state
        }

        val updatedBoard = state.board.toMutableList()

        updatedBoard[cellIndex] = state.currentPlayer

        val hasWinner = checkWinner(
            board = updatedBoard,
            player = state.currentPlayer
        )

        val winner = if (hasWinner) state.currentPlayer else null
        
        val isDraw = winner == null && updatedBoard.all { cell ->
            cell != null
        }

        val nextPlayer = when (state.currentPlayer) {
            Mark.X -> Mark.O
            Mark.O -> Mark.X
        }

        return state.copy(
            board = updatedBoard,
            currentPlayer = if (winner == null && !isDraw) nextPlayer else state.currentPlayer,
            winner = winner,
            isDraw = isDraw
        )
    }
}