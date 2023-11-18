package com.example.presentation.common_components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.presentation.R
import com.example.presentation.theme.LightGray
import com.example.presentation.theme.LightGreen
import com.example.presentation.theme.LightWhite
import com.example.presentation.utils.Locators.TAG_STRING_ERROR_DESCRIPTION_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_ERROR_LOTTIE_ANIMATION
import com.example.presentation.utils.Locators.TAG_STRING_ERROR_RETRY_BUTTON
import com.example.presentation.utils.Locators.TAG_STRING_ERROR_TITLE_LABEL

@Composable
fun ErrorSection(
    onRefreshButtonClicked: () -> Unit
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error_animation))
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightWhite)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .testTag(TAG_STRING_ERROR_LOTTIE_ANIMATION)
                .padding(top = 50.dp, bottom = 25.dp)
                .fillMaxWidth().height(340.dp)
        )

        Text(
            text = stringResource(id = R.string.something_went_wrong),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .testTag(TAG_STRING_ERROR_TITLE_LABEL)
                .padding(bottom = 10.dp)
        )

        Text(
            text = stringResource(id = R.string.alien_blocking_your_signal),
            style = MaterialTheme.typography.bodyLarge,
            color = LightGray,
            modifier = Modifier.testTag(TAG_STRING_ERROR_DESCRIPTION_LABEL)
        )
        
        Spacer(modifier = Modifier.height(80.dp))

        OutlinedButton(
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
            border = BorderStroke(2.dp, LightGreen),
            modifier = Modifier
                .testTag(TAG_STRING_ERROR_RETRY_BUTTON)
                .fillMaxWidth(0.8f),
            onClick = {
                onRefreshButtonClicked()
            }
        ) {
            Text(
                text = stringResource(id = R.string.retry),
                fontSize = 18.sp,
                color = LightGreen,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewNoInternetConnection() {
    ErrorSection(onRefreshButtonClicked = {})
}

