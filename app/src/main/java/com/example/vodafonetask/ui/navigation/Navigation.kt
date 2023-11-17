package com.example.vodafonetask.ui.navigation

import android.util.Log
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.presentation.screens.trending_screen.TrendingGithubScreen
import com.example.presentation.screens.trending_screen.TrendingViewModel
import com.example.presentation.utils.Constants.Companion.NAME_ARGUMENT_KEY
import com.example.presentation.utils.Constants.Companion.OWNER_ARGUMENT_KEY

@ExperimentalComposeUiApi
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.semantics { testTagsAsResourceId = true },
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(
            route = Screen.Home.route,
            enterTransition = {
                Log.d("details", "Home: enterTransition ->  fadeIn Tween")
                return@composable fadeIn(tween(1000))
            }, exitTransition = {
                Log.d("details", "Home: exitTransition -> SlideDirection.Start")
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                Log.d("details", "Home: popEnterTransition -> SlideDirection.End")
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }
        ) {
            val trendingViewModel: TrendingViewModel = hiltViewModel()
            val trendingUiState =
                trendingViewModel.trendingUiState.collectAsState() // use with lifecycle
            TrendingGithubScreen(
                trendingUiState = trendingUiState.value,
                onPulledToRefresh = trendingViewModel::requestTrendingGithub,
                onRefreshButtonClicked = trendingViewModel::requestTrendingGithub,
                onItemClicked = { owner, repoName ->
                    navController.navigate(
                        Screen.Details.passOwnerAndName(
                            owner = owner,
                            name = repoName
                        )
                    )
                }
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(OWNER_ARGUMENT_KEY) {
                    type = NavType.StringType
                },
                navArgument(NAME_ARGUMENT_KEY) {
                    type = NavType.StringType
                },
            ),

            enterTransition = {
                Log.d("details", "Details: enterTransition -> SlideDirection.Start")
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            },
            popExitTransition = {
                Log.d("details", "Details: popExitTransition -> SlideDirection.End")
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }
        ) {
            val owner = it.arguments?.getString(OWNER_ARGUMENT_KEY)
            val name = it.arguments?.getString(NAME_ARGUMENT_KEY)
            LaunchedEffect(key1 = Unit) {
                Log.d("details", "in details $owner, $name")
            }
        }
    }
}