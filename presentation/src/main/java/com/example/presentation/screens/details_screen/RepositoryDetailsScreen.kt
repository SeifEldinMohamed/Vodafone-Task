package com.example.presentation.screens.details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.presentation.R
import com.example.presentation.common_components.AnimateShimmerList
import com.example.presentation.common_components.AppBar
import com.example.presentation.common_components.ErrorSection
import com.example.presentation.model.RepositoryDetailsUiModel
import com.example.presentation.screens.details_screen.preview.fakeRepositoryDetailsUiModel
import com.example.presentation.screens.details_screen.ui_state.RepositoryDetailsUiState
import com.example.presentation.theme.VodafoneTaskTheme
import com.example.presentation.utils.Locators
import com.example.presentation.utils.Locators.TAG_STRING_DETAILS_APP_BAR_TITLE_LABEL

@Composable
fun DetailsScreen(
    repositoryDetailsUiState: RepositoryDetailsUiState,
    onRefreshButtonClicked: () -> Unit,
    onShowIssuesClicked: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(
            titleText = stringResource(R.string.details_app_bar_title),
            titleTag = TAG_STRING_DETAILS_APP_BAR_TITLE_LABEL
        )
        when {
            repositoryDetailsUiState.isLoading -> {
                AnimateShimmerList()
            }
            repositoryDetailsUiState.repositoryDetails != null -> {
                DetailsContent(repositoryDetailsUiState.repositoryDetails, onShowIssuesClicked)
            }
            else ->{
                ErrorSection(
                    onRefreshButtonClicked = onRefreshButtonClicked,
                    customErrorExceptionUiModel = repositoryDetailsUiState.customErrorExceptionUiModel
                )
            }
        }
    }
}

@Composable
fun DetailsContent(
    repositoryDetails: RepositoryDetailsUiModel,
    onShowIssuesClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = repositoryDetails.avatar)
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(1000)
                        placeholder(R.drawable.ic_github_placeholser)
                    })
                    .build()
            ),
            contentDescription = stringResource(R.string.accessbility_details_your_avatar_image),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .testTag(Locators.TAG_STRING_DETAILS_AVATAR_IMAGE)
                .size(150.dp)
                .clip(RoundedCornerShape(150.dp))
                .padding(top = 16.dp),
        )
        Text(
            text = repositoryDetails.name,
            modifier = Modifier
                .testTag(Locators.TAG_STRING_DETAILS_NAME_LABEL)
                .padding(top = 12.dp)
                .padding(bottom = 16.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
           style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier.wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = repositoryDetails.stars,
                modifier = Modifier
                    .testTag(Locators.TAG_STRING_DETAILS_STARS_NUMBER_LABEL)
                    .padding(end = 6.dp),
                style = MaterialTheme.typography.bodyLarge
            )

            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "star icon",
                colorFilter = ColorFilter.tint(Color.Yellow),
                modifier = Modifier
                    .testTag(Locators.TAG_STRING_DETAILS_STAR_ICON)
                    .size(35.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = repositoryDetails.language,
                modifier = Modifier
                    .padding(end = 6.dp)
                    .testTag(Locators.TAG_STRING_DETAILS_LANGUAGE_LABEL),
                style = MaterialTheme.typography.bodyLarge
            )

            Box(
                modifier = Modifier
                    .testTag(Locators.TAG_STRING_DETAILS_CIRCLE_ICON)
                    .size(20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Blue)
            )
            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = repositoryDetails.forks,
                modifier = Modifier
                    .testTag(Locators.TAG_STRING_DETAILS_FORKS_NUMBER_LABEL)
                    .padding(end = 6.dp),
                style = MaterialTheme.typography.bodyLarge
            )

            Image(
                painter = painterResource(id = R.drawable.ic_fork),
                contentDescription = "fork icon",
                modifier = Modifier
                    .testTag(Locators.TAG_STRING_DETAILS_FORK_ICON)
                    .size(35.dp)
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = repositoryDetails.description,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .testTag(Locators.TAG_STRING_DETAILS_DESC_LABEL),
            style = MaterialTheme.typography.bodyLarge,
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 16.dp),
            onClick = onShowIssuesClicked
        ) {
            Text(
                text = stringResource(R.string.show_issues),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTrendingGithubScreen() {
    VodafoneTaskTheme(darkTheme = false) {
        DetailsScreen(
            repositoryDetailsUiState = RepositoryDetailsUiState(
                repositoryDetails = fakeRepositoryDetailsUiModel
            ),
            onShowIssuesClicked = {},
            onRefreshButtonClicked = {}
        )
    }
}