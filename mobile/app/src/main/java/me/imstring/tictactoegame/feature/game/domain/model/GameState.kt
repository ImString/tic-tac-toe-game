package me.imstring.tictactoegame.feature.game.domain.model

data class GameState(
    val board: List<Mark?> = List(9) { null },
    val currentPlayer: Mark = Mark.X,
    val winner: Mark? = null,
    val isDraw: Boolean = false
)