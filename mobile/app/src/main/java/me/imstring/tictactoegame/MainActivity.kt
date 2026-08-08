package me.imstring.tictactoegame

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import me.imstring.tictactoegame.ui.icons.OIcon
import me.imstring.tictactoegame.ui.icons.XIcon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

fun addZero(number: Int): String {
    if (number < 10) return "0${number}"
    return number.toString()
}

fun checkWinner(
    checks: Map<Int, ButtonType>,
    player: ButtonType
): Boolean {
    return false
}

enum class ButtonType(
    val text: String,
    val backgroundColor: Color,
    val borderColor: Color,
    val icon: ImageVector?
) {
    CHECK_X(
        "X",
        Color(0x332475C5),
        Color(0xFF2475C5),
        XIcon
    ),
    CHECK_O(
        "O",
        Color(0x33E45651),
        Color(0xFFE45651),
        OIcon
    ),
    UNCHECK(
        "",
        Color.Transparent,
        Color(0xFF212835),
        null
    )
}

@Composable
fun CardButton(index: Int, buttonType: ButtonType, onChange: (Int) -> Unit) {
    Button(
        onClick = {
            onChange(index)
            Log.d("CLICK", "Clicou no botão de id $index")
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonType.backgroundColor,
        ),
        modifier = Modifier
            .padding(end = 14.dp)
            .size(80.dp),
        border = BorderStroke(width = 1.dp, color = buttonType.borderColor),
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        if(buttonType.icon != null)
            Icon(
                imageVector = buttonType.icon,
                contentDescription = buttonType.text,
                modifier = Modifier.size(28.dp),
                tint = buttonType.borderColor
            )
    }
}

@Composable
fun Home() {
    val activeTurn = remember { mutableIntStateOf(1) }
    val checks = remember { mutableStateMapOf<Int, ButtonType>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C1017)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Jogador ${addZero(activeTurn.intValue)}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFADADAD)
        )

        var customIndex = 1;
        Column {
            for (row in 1..3) {
                Row(
                    modifier = Modifier.padding(top = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in 1..3) {
                        CardButton(
                            customIndex,
                            checks.getOrDefault(customIndex, ButtonType.UNCHECK),
                            onChange = click@{ selectedIndex ->
                                if (checks.containsKey(selectedIndex)) return@click;

                                checks[selectedIndex] = if (activeTurn.intValue == 1) ButtonType.CHECK_X else ButtonType.CHECK_O
                                activeTurn.intValue = if (activeTurn.intValue == 1) 2 else 1
                            }
                        )

                        customIndex++;
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomePreview() {
    Home()
}
