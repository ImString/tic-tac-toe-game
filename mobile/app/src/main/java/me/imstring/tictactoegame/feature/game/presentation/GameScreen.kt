package me.imstring.tictactoegame.feature.game.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.imstring.tictactoegame.feature.game.domain.model.GameState
import me.imstring.tictactoegame.feature.game.presentation.components.GameBoard
import me.imstring.tictactoegame.feature.game.presentation.components.GameStatus
import me.imstring.tictactoegame.feature.game.presentation.components.PlayAgainButton

@Composable
fun GameScreen(
    state: GameState,
    onCellClick: (Int) -> Unit,
    onPlayAgain: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C1017))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0C1017)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GameStatus(
                currentPlayer = state.currentPlayer,
                winner = state.winner,
                isDraw = state.isDraw
            )

            Spacer(modifier = Modifier.height(48.dp))

            GameBoard(
                board = state.board,
                onCellClick = onCellClick
            )
        }

        if (state.isDraw || state.winner != null) {
            PlayAgainButton(
                onClick = onPlayAgain,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(
                        horizontal = 18.dp,
                        vertical = 16.dp
                    )
            )
        }
    }
}