package me.imstring.tictactoegame.feature.game.presentation.preview

import androidx.compose.runtime.Composable
import me.imstring.tictactoegame.feature.game.domain.model.GameState
import me.imstring.tictactoegame.feature.game.presentation.GameScreen
import me.imstring.tictactoegame.ui.preview.ThemePreviews
import me.imstring.tictactoegame.ui.theme.TicTacToeGameTheme

@ThemePreviews
@Composable
private fun GameScreenInitialPreview() {
    GameScreenPreview(state = GamePreviewData.initial)
}

@ThemePreviews
@Composable
private fun GameScreenXWinnerPreview() {
    GameScreenPreview(state = GamePreviewData.xWinner)
}

@ThemePreviews
@Composable
private fun GameScreenOWinnerPreview() {
    GameScreenPreview(state = GamePreviewData.oWinner)
}

@ThemePreviews
@Composable
private fun GameScreenDrawPreview() {
    GameScreenPreview(state = GamePreviewData.draw)
}

@Composable
private fun GameScreenPreview(state: GameState) {
    TicTacToeGameTheme {
        GameScreen(
            state = state,
            onCellClick = {},
            onPlayAgain = {}
        )
    }
}
