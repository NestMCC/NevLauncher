/*
 * Zalith Launcher 2
 * Copyright (C) 2025-2026 MovTery <movtery228@qq.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/gpl-3.0.txt>.
 */

package com.movtery.zalithlauncher.filemanager.ui.theme

import com.movtery.zalithlauncher.ui.theme.LocalNevStyle
import com.movtery.zalithlauncher.ui.theme.NevCardBorder
import com.movtery.zalithlauncher.ui.theme.NevRed
import com.movtery.zalithlauncher.ui.theme.onBackgroundColor
import com.movtery.zalithlauncher.ui.theme.backgroundColor
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun fmBackgroundColor(): Color = backgroundColor()
@Composable
fun fmOnBackgroundColor(): Color = onBackgroundColor()

@Composable
fun fmCardColor(): Color = NevRed.Panel.copy(alpha = LocalNevStyle.current.cardAlpha)
@Composable
fun fmOnCardColor(): Color = MaterialTheme.colorScheme.onSurface

@Composable
fun fmSecondaryTextColor(): Color = MaterialTheme.colorScheme.onSurfaceVariant

@Composable
fun fmErrorColor(): Color = MaterialTheme.colorScheme.error

@Composable
fun fmSelectionColor(): Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.16f)

@Composable
fun fmTopbarColors(): TopAppBarColors = TopAppBarDefaults.topAppBarColors(
    containerColor = Color.Transparent,
    scrolledContainerColor = Color.Transparent,
    navigationIconContentColor = fmOnBackgroundColor(),
    titleContentColor = fmOnBackgroundColor(),
    actionIconContentColor = fmOnBackgroundColor(),
    subtitleContentColor = fmOnBackgroundColor(),
)

/** Warna latar menu popup File: sama dengan menu popup launcher. */
@Composable
fun fmMenuContainerColor(): Color = NevRed.PanelDeep

/** Garis tepi menu popup File: sama dengan menu popup launcher. */
@Composable
fun fmMenuBorder(): BorderStroke = NevCardBorder

object FmAnimations {
    /** 滑动触发回弹动画时长（ms） */
    const val SWIPE_BACK_MS = 220
    /** 定位高亮闪烁停留时长（ms） */
    const val LOCATE_HIGHLIGHT_MS = 1400L
    /** 内容切换淡出时长（ms） */
    const val FADE_OUT_MS = 120
    /** 内容切换淡入时长（ms） */
    const val FADE_IN_MS = 180
}
