package me.imstring.tictactoegame

import androidx.compose.runtime.Composable
import me.imstring.tictactoegame.feature.game.presentation.GameRoute
import me.imstring.tictactoegame.ui.theme.TicTacToeGameTheme

@Composable
fun TicTacToeApp() {
    TicTacToeGameTheme() {
        GameRoute()
    }
}