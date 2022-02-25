package com.ipcoding.guesstheword.feature.presentation.game.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun KeyboardIcons(
    width: Dp,
    height: Dp,
    onClick: () -> Unit,
    imageVector: ImageVector,
    contentDescription: String
) {
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .padding(AppTheme.dimensions.spaceSuperSmall)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = AppTheme.dimensions.spaceSuperSmall,
                    color = AppTheme.colors.primary,
                    shape = AppTheme.customShapes.roundedCornerShapeSmall
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = contentDescription,
                tint = AppTheme.colors.primary,
                modifier = Modifier.padding(AppTheme.dimensions.spaceExtraSmall)
            )
        }
    }
}