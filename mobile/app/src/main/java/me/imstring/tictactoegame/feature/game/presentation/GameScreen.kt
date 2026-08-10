package me.imstring.tictactoegame.feature.game.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.imstring.tictactoegame.feature.game.domain.model.GameState
import me.imstring.tictactoegame.feature.game.presentation.components.GameBoard

@Composable
fun GameScreen(
    state: GameState,
    onCellClick: (Int) -> Unit
) {
    val playerNumber = if (state.currentPlayer.name == "X") 1 else 2

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C1017)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Jogador ${playerNumber.toString().padStart(2, '0')}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFADADAD)
        )
        GameBoard(
            board = state.board,
            onCellClick = onCellClick
        )
    }
}