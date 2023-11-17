package com.example.presentation.common_components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.presentation.utils.Locators.TAG_STRING_LOADING_SHIMMER_LIST

@Composable
fun AnimateShimmerList() {
    LazyColumn(modifier = Modifier.testTag(TAG_STRING_LOADING_SHIMMER_LIST)){
        items(10){
            AnimatedShimmerTrendingItem()
        }
    }
}