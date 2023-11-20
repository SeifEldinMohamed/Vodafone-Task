package com.example.vodafonetask.ui.navigation

import android.annotation.SuppressLint
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
import com.example.presentation.screens.details_screen.DetailsScreen
import com.example.presentation.screens.details_screen.RepositoryDetailsViewModel
import com.example.presentation.screens.issues_screen.IssuesScreen
import com.example.presentation.screens.issues_screen.IssuesViewModel
import com.example.presentation.screens.trending_screen.TrendingGithubScreen
import com.example.presentation.screens.trending_screen.TrendingViewModel
import com.example.presentation.utils.Constants.Companion.NAME_ARGUMENT_KEY
import com.example.presentation.utils.Constants.Companion.OWNER_ARGUMENT_KEY

@SuppressLint("RestrictedApi")
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
                return@composable fadeIn(tween(1000))
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
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
                onRefreshButtonClicked = { trendingViewModel.requestTrendingGithub(isForceFetch = true) },
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
            exitTransition = {
                val currentDestination = navController.currentDestination?.route
                return@composable  if (currentDestination == Screen.Home.route){
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    )
                }
                else {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    )
                }

            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }
        ) {
            val owner = it.arguments?.getString(OWNER_ARGUMENT_KEY)
            val name = it.arguments?.getString(NAME_ARGUMENT_KEY)
            if (owner != null && name != null) {
                val repositoryDetailsViewModel: RepositoryDetailsViewModel = hiltViewModel()
                LaunchedEffect(key1 = Unit) {
                    repositoryDetailsViewModel.requestRepositoryDetails(owner, name)
                }

                val repositoryDetailsUiState =
                    repositoryDetailsViewModel.repoDetailsUiState.collectAsState() // use with lifecycle
                DetailsScreen(
                    repositoryDetailsUiState = repositoryDetailsUiState.value,
                    onRefreshButtonClicked = {
                        repositoryDetailsViewModel.requestRepositoryDetails(owner, name)
                    },
                    onShowIssuesClicked = {
                        navController.navigate(Screen.Issues.passOwnerAndName(owner, name))
                    },
                    onBackArrowClicked = { navController.navigateUp() }
                )
            }
        }

        composable(
            route = Screen.Issues.route,
            arguments = listOf(
                navArgument(OWNER_ARGUMENT_KEY) {
                    type = NavType.StringType
                },
                navArgument(NAME_ARGUMENT_KEY) {
                    type = NavType.StringType
                },
            ),
            exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }
        ) {
            val owner = it.arguments?.getString(OWNER_ARGUMENT_KEY)
            val name = it.arguments?.getString(NAME_ARGUMENT_KEY)
            if (owner != null && name != null) {
                val issuesViewModel: IssuesViewModel = hiltViewModel()
                LaunchedEffect(key1 = Unit) {
                    issuesViewModel.requestIssues(owner, name)
                }

                val issuesUiState =
                    issuesViewModel.issuesUiState.collectAsState() // use with lifecycle
                IssuesScreen(
                    issuesUiState = issuesUiState.value,
                    onRefreshList = {
                        issuesViewModel.requestIssues(owner, name)
                    },
                    onBackArrowClicked = { navController.navigateUp() }
                )
            }
        }
    }
}