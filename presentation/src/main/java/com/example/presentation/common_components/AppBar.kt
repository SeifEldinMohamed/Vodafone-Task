package com.example.presentation.common_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.R

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    titleText: String = stringResource(id = R.string.github_repository),
    titleTextColor: Color = Color.Black,
    titleTextStyle: TextStyle = MaterialTheme.typography.h5,
    titleFontWeight: FontWeight = FontWeight.Bold,
    titleTag: String = "",
    appBarBackgroundColor: Color = Color.White
) {
    TopAppBar(
        title = {
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
        },
        backgroundColor = appBarBackgroundColor,
    )
    Divider()
}

@Preview
@Composable
fun PreviewAppBar() {
    AppBar()
}