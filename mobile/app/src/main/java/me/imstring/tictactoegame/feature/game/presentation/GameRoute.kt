package me.imstring.tictactoegame.feature.game.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import me.imstring.tictactoegame.feature.game.domain.GameEngine
import me.imstring.tictactoegame.feature.game.domain.model.GameState

@Composable
fun GameRoute() {
    var gameState by remember {
        mutableStateOf(GameState())
    }

    GameScreen(
        state = gameState,
        onCellClick = { cellIndex ->
            gameState = GameEngine.play(
                state = gameState,
                cellIndex = cellIndex
            )
        }
    )
}