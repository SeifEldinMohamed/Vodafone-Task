package com.example.presentation.screens.trending_screen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.presentation.screens.trending_screen.ui_state.TrendingUiState
import com.example.presentation.utils.Locators.TAG_STRING_ERROR_DESCRIPTION_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_ERROR_LOTTIE_ANIMATION
import com.example.presentation.utils.Locators.TAG_STRING_ERROR_RETRY_BUTTON
import com.example.presentation.utils.Locators.TAG_STRING_ERROR_TITLE_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_AVATAR_IMAGE
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_ITEM_Owner_NAME_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_ITEM_NAME_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_LOADING_SHIMMER_TRENDING_LIST
import com.example.presentation.utils.Locators.TAG_STRING_TRENDING_LIST
import org.junit.Rule
import org.junit.Test

@ExperimentalMaterialApi
class TrendingGithubScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun testTrendingGithubScreen_ContentLoading() {
        val loadingUiState = TrendingUiState(isLoading = true)
        composeTestRule.setContent {
            TrendingGithubScreen(
                trendingUiState = loadingUiState,
                onPulledToRefresh = {},
                onRefreshButtonClicked = {},
                onItemClicked = {_,_->}
            )
        }

        composeTestRule.onNodeWithTag(TAG_STRING_LOADING_SHIMMER_TRENDING_LIST).assertExists()

    }

    @Test
    fun testTrendingGithubScreen_ErrorState() {
        val errorUiState = TrendingUiState(isError = true)
        composeTestRule.setContent {
            TrendingGithubScreen(
                trendingUiState = errorUiState,
                onPulledToRefresh = {},
                onRefreshButtonClicked = {},
                onItemClicked = {_,_->}
            )
        }

        composeTestRule.onNodeWithTag(TAG_STRING_ERROR_LOTTIE_ANIMATION)
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_STRING_ERROR_TITLE_LABEL)
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_STRING_ERROR_DESCRIPTION_LABEL)
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_STRING_ERROR_RETRY_BUTTON)
            .assertIsDisplayed()
    }

    @Test
    fun testTrendingGithubScreen_ContentLoaded_CheckListCount() {
        val loadedUiState = TrendingUiState(
            trendingGithubPagingDataFlow = fakeTrendingGithubLazyPagingUiModel
        )
        composeTestRule.setContent {
            TrendingGithubScreen(
                trendingUiState = loadedUiState,
                onPulledToRefresh = {},
                onRefreshButtonClicked = {},
                onItemClicked = {_,_->}
            )
        }

        // Assert that the loaded content is displayed
        composeTestRule.onNodeWithTag(TAG_STRING_TRENDING_LIST)
            .onChildren()
            .assertCountEquals(fakeTrendingGithubListUiModel.size + 1) // plus 1 for progressIndicatorItem
    }

    @Test
    fun testTrendingGithubScreen_ContentLoaded_ClickONItemToExpand() {
        val loadedUiState = TrendingUiState(
            trendingGithubPagingDataFlow = fakeTrendingGithubLazyPagingUiModel
        )
        composeTestRule.setContent {
            TrendingGithubScreen(
                trendingUiState = loadedUiState,
                onPulledToRefresh = {},
                onRefreshButtonClicked = {},
                onItemClicked = {_,_->}
            )
        }

        composeTestRule.apply {
            onRoot().printToLog("ui test")

            checkExpandableItemIsExists(0)

//            onNodeWithTag(TAG_STRING_TRENDING_LIST)
//                .onChildren()
//                .onFirst()
//                .performClick()

              //  checkExpandableItemIsExpanded(0)
        }
    }

    @Test
    fun testTrendingGithubScreen_ContentLoaded_CHECK_ITEMS_EXISTS() {
        val loadedUiState = TrendingUiState(
            trendingGithubPagingDataFlow = fakeTrendingGithubLazyPagingUiModel
        )
        composeTestRule.setContent {
            TrendingGithubScreen(
                trendingUiState = loadedUiState,
                onPulledToRefresh = {},
                onRefreshButtonClicked = {},
                onItemClicked = {_,_->}
            )
        }

        composeTestRule.apply {
            onRoot().printToLog("ui test")

            for (index in fakeTrendingGithubListUiModel.indices) {
                // check items exists
                checkExpandableItemIsExists(index)
            }
        }
    }
}
//
//private fun ComposeContentTestRule.checkExpandableItemIsExpanded(index: Int) {
//    onNodeWithTag(
//        String.format(TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL, index),
//        useUnmergedTree = true
//    ).assertExists()
//    onNodeWithTag(
//        String.format(TAG_STRING_EXPANDABLE_ITEM_CIRCLE_ICON, index),
//        useUnmergedTree = true
//    ).assertExists()
//    onNodeWithTag(
//        String.format(TAG_STRING_EXPANDABLE_ITEM_LANGUAGE_LABEL, index),
//        useUnmergedTree = true
//    ).assertExists()
//    onNodeWithTag(
//        String.format(TAG_STRING_EXPANDABLE_ITEM_STAR_ICON, index),
//        useUnmergedTree = true
//    ).assertExists()
//    onNodeWithTag(
//        String.format(TAG_STRING_EXPANDABLE_ITEM_STARS_NUMBER_LABEL, index),
//        useUnmergedTree = true
//    ).assertExists()
//}

private fun ComposeContentTestRule.checkExpandableItemIsExists(index: Int) {
    onNodeWithTag( // name
        String.format(TAG_STRING_EXPANDABLE_ITEM_NAME_LABEL, index),
        useUnmergedTree = true
    ).assertExists().assertTextContains(fakeTrendingGithubListUiModel.first().name)
    onNodeWithTag( // owner name
        String.format(TAG_STRING_EXPANDABLE_ITEM_Owner_NAME_LABEL, index),
        useUnmergedTree = true
    ).assertExists().assertTextContains(fakeTrendingGithubListUiModel.first().owner)
    onNodeWithTag( // avatar image
        String.format(TAG_STRING_EXPANDABLE_AVATAR_IMAGE, index),
        useUnmergedTree = true
    ).assertExists()
    onNodeWithTag( // description
        String.format(TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL, index),
        useUnmergedTree = true
    ).assertExists()
//    onNodeWithTag(
//        String.format(TAG_STRING_EXPANDABLE_ITEM_CIRCLE_ICON, index),
//        useUnmergedTree = true
//    ).assertDoesNotExist()
//    onNodeWithTag(
//        String.format(TAG_STRING_EXPANDABLE_ITEM_LANGUAGE_LABEL, index),
//        useUnmergedTree = true
//    ).assertDoesNotExist()
//    onNodeWithTag(
//        String.format(TAG_STRING_EXPANDABLE_ITEM_STAR_ICON, index),
//        useUnmergedTree = true
//    ).assertDoesNotExist()
//    onNodeWithTag(
//        String.format(TAG_STRING_EXPANDABLE_ITEM_STARS_NUMBER_LABEL, index),
//        useUnmergedTree = true
//    ).assertDoesNotExist()
}