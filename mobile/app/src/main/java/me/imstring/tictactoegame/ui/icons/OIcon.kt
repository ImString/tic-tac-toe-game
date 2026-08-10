package me.imstring.tictactoegame.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val OIcon: ImageVector
    get() {
        if (_OIcon != null) return _OIcon!!
        
        _OIcon = ImageVector.Builder(
            name = "OIcon",
            defaultWidth = 32.dp,
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFFFFFFFF)),
                strokeLineWidth = 4f
            ) {
                moveTo(28f, 16f)
                arcTo(12f, 12f, 0f, false, true, 16f, 28f)
                arcTo(12f, 12f, 0f, false, true, 4f, 16f)
                arcTo(12f, 12f, 0f, false, true, 28f, 16f)
                close()
            }
        }.build()
        
        return _OIcon!!
    }

private var _OIcon: ImageVector? = null

