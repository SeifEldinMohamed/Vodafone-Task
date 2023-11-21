package com.example.presentation.common_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    titleText: String = stringResource(id = R.string.github_repository),
    titleTextColor: Color = MaterialTheme.colorScheme.onSurface,
    titleTextStyle: TextStyle = MaterialTheme.typography.titleLarge,
    titleFontWeight: FontWeight = FontWeight.Bold,
    titleTag: String = "",
    appBarBackgroundColor: Color = Color.White,
    onBackArrowClicked: () -> Unit,
    showBackArrow: Boolean = true
) {
    TopAppBar(
        title = {
           Row(modifier = Modifier.fillMaxWidth()) {
               if (showBackArrow) {
                Box(
                    modifier = Modifier.clickable {
                        onBackArrowClicked()
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back_arrow),
                        contentDescription = stringResource(R.string.back_arrow),
                        modifier = Modifier.padding(8.dp),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.inversePrimary)
                    )
                }
               }
               Text(
                   text = titleText,
                   textAlign = TextAlign.Center,
                   color = titleTextColor,
                   style = titleTextStyle,
                   fontWeight = titleFontWeight,
                   modifier = modifier
                       .testTag(titleTag)
                       .fillMaxWidth()
               )
           }
        },
        modifier = Modifier.background(appBarBackgroundColor),
    )
    Divider()
}

@Preview
@Composable
fun PreviewAppBar() {
    AppBar(
        onBackArrowClicked = {}
    )
}