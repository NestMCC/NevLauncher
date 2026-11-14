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

package com.movtery.zalithlauncher.filemanager.ui.components

import com.movtery.zalithlauncher.ui.theme.nevShape
import com.movtery.zalithlauncher.ui.theme.LocalNevStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.alpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.clickable
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.movtery.zalithlauncher.R
import com.movtery.zalithlauncher.filemanager.ui.theme.fmCardColor
import com.movtery.zalithlauncher.filemanager.ui.theme.fmOnCardColor

/** 竖屏布局的底部导航栏 */
@Composable
fun FmBottomBar(
    multiSelect: Boolean,
    canBack: Boolean,
    canForward: Boolean,
    canParent: Boolean,
    onBack: () -> Unit,
    onForward: () -> Unit,
    onNew: () -> Unit,
    onParent: () -> Unit,
    onSelectAll: () -> Unit,
    onClearSelection: () -> Unit,
    onRangeSelectHelp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val neon = MaterialTheme.colorScheme.primary
    val cyber = LocalNevStyle.current.cyber
    Surface(
        modifier = modifier.then(
            if (cyber) {
                //garis neon di tepi atas bar bawah (gaya Cyber)
                Modifier.drawBehind {
                    drawLine(neon, Offset(0f, 0f), Offset(size.width, 0f), 1.5.dp.toPx())
                }
            } else Modifier
        ),
        color = fmCardColor(),
        contentColor = fmOnCardColor(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            if (multiSelect) {
                IconButton(onClick = onSelectAll) {
                    Icon(
                        painter = painterResource(R.drawable.ic_select_all),
                        contentDescription = stringResource(R.string.fm_select_all)
                    )
                }
                IconButton(onClick = onClearSelection) {
                    Icon(
                        painter = painterResource(R.drawable.ic_deselect),
                        contentDescription = stringResource(R.string.fm_clear_selection)
                    )
                }
                IconButton(onClick = onRangeSelectHelp) {
                    Icon(
                        painter = painterResource(R.drawable.ic_swipe),
                        contentDescription = stringResource(R.string.fm_range_select_help)
                    )
                }
            } else {
                IconButton(onClick = onBack, enabled = canBack) {
                    Icon(
                        painter = painterResource(R.drawable.ic_keyboard_arrow_left),
                        contentDescription = stringResource(R.string.fm_nav_back)
                    )
                }
                IconButton(onClick = onForward, enabled = canForward) {
                    Icon(
                        painter = painterResource(R.drawable.ic_keyboard_arrow_right),
                        contentDescription = stringResource(R.string.fm_nav_forward)
                    )
                }
                IconButton(onClick = onNew) {
                    Icon(
                        painter = painterResource(R.drawable.ic_add),
                        contentDescription = stringResource(R.string.control_editor_layers_create)
                    )
                }
                IconButton(onClick = onParent, enabled = canParent) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_upward),
                        contentDescription = stringResource(R.string.fm_nav_parent)
                    )
                }
            }
        }
    }
}

/** 横屏布局的侧边导航栏 */
@Composable
fun FmNavRail(
    multiSelect: Boolean,
    canBack: Boolean,
    canForward: Boolean,
    canParent: Boolean,
    onBack: () -> Unit,
    onForward: () -> Unit,
    onNew: () -> Unit,
    onParent: () -> Unit,
    onSelectAll: () -> Unit,
    onClearSelection: () -> Unit,
    onRangeSelectHelp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val listScroll = rememberScrollState()
    Column(
        modifier
            .fillMaxHeight()
            .padding(vertical = 8.dp)
            .verticalScroll(listScroll),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (multiSelect) {
            RailItem(
                icon = painterResource(R.drawable.ic_select_all),
                labelRes = R.string.fm_select_all,
                onClick = onSelectAll
            )
            RailItem(
                icon = painterResource(R.drawable.ic_deselect),
                labelRes = R.string.fm_clear_selection,
                onClick = onClearSelection
            )
            RailItem(
                icon = painterResource(R.drawable.ic_swipe),
                labelRes = R.string.fm_range_select_help,
                onClick = onRangeSelectHelp
            )
        } else {
            RailItem(
                icon = painterResource(R.drawable.ic_keyboard_arrow_up),
                labelRes = R.string.fm_nav_back,
                onClick = onBack,
                enabled = canBack
            )
            RailItem(
                icon = painterResource(R.drawable.ic_keyboard_arrow_down),
                labelRes = R.string.fm_nav_forward,
                onClick = onForward,
                enabled = canForward
            )
            RailItem(
                icon = painterResource(R.drawable.ic_add),
                labelRes = R.string.control_editor_layers_create,
                onClick = onNew
            )
            RailItem(
                icon = painterResource(R.drawable.ic_arrow_back),
                labelRes = R.string.fm_nav_parent,
                onClick = onParent,
                enabled = canParent
            )
        }
    }
}

/**
 * Item menu samping File: mengikuti item sidebar launcher (ikon + label, warna tema).
 * Gaya Cyber: label huruf kapital dan bingkai neon tipis.
 */
@Composable
private fun RailItem(
    icon: Painter,
    labelRes: Int,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    val cyber = LocalNevStyle.current.cyber
    val shape = nevShape(14.dp)
    val tint = MaterialTheme.colorScheme.primary
    val label = stringResource(labelRes)
    Column(
        modifier = Modifier
            .width(72.dp)
            .alpha(if (enabled) 1f else 0.38f)
            .clip(shape)
            .then(
                if (cyber) Modifier.border(1.dp, tint.copy(alpha = 0.35f), shape) else Modifier
            )
            .clickable(enabled = enabled, onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = icon,
            contentDescription = null,
            tint = tint
        )
        Text(
            text = if (cyber) label.uppercase() else label,
            style = MaterialTheme.typography.labelSmall,
            color = fmOnCardColor(),
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}
