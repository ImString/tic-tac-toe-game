package me.imstring.tictactoegame.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val XIcon: ImageVector
    get() {
        if (_XIcon != null) return _XIcon!!
        
        _XIcon = ImageVector.Builder(
            name = "XIcon",
            defaultWidth = 32.dp,
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(25.9779f, 3f)
                lineTo(28.8063f, 5.82843f)
                lineTo(5.82843f, 28.8063f)
                lineTo(3f, 25.9779f)
                lineTo(25.9779f, 3f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF))
            ) {
                moveTo(6.32753f, 3f)
                lineTo(3.4991f, 5.82843f)
                lineTo(26.477f, 28.8063f)
                lineTo(29.3054f, 25.9779f)
                lineTo(6.32753f, 3f)
                close()
            }
        }.build()
        
        return _XIcon!!
    }

private var _XIcon: ImageVector? = null

