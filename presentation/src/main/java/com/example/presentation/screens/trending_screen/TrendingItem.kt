package com.example.presentation.screens.trending_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.presentation.R
import com.example.presentation.model.TrendingGithubUiModel
import com.example.presentation.screens.trending_screen.preview.trendingGithubUiModel
import com.example.presentation.theme.VodafoneTaskTheme
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_AVATAR_IMAGE
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_ITEM_Owner_NAME_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_ITEM_NAME_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_ITEM_STARS_NUMBER_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_ITEM_STAR_ICON

@Composable
fun TrendingItem(
    trendingGithubUiModel: TrendingGithubUiModel,
    index: Int,
    onItemClicked: (owner: String, repoName: String) -> Unit
) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onItemClicked(trendingGithubUiModel.owner, trendingGithubUiModel.name)
        }
        .padding(top = 8.dp)

    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = trendingGithubUiModel.avatar)
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(1000)
                    })
                    .build()
            ),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .testTag(
                    String.format(
                        TAG_STRING_EXPANDABLE_AVATAR_IMAGE, index
                    )
                )
                .size(40.dp)
                .padding(top = 8.dp, start = 8.dp)
                .clip(RoundedCornerShape(80.dp))
        )

        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = trendingGithubUiModel.name,
                    modifier = Modifier
                        .testTag(
                            String.format(
                                TAG_STRING_EXPANDABLE_ITEM_NAME_LABEL, index
                            )
                        )
                        .padding(bottom = 6.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = trendingGithubUiModel.stars.toString(),
                    modifier = Modifier
                        .testTag(
                            String.format(
                                TAG_STRING_EXPANDABLE_ITEM_STARS_NUMBER_LABEL, index
                            )
                        )
                        .padding(end = 5.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "start icon",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .testTag(
                            String.format(
                                TAG_STRING_EXPANDABLE_ITEM_STAR_ICON, index
                            )
                        )
                        .size(30.dp)
                        .padding(end = 5.dp)
                )
            }

            Text(
                text = trendingGithubUiModel.owner,
                modifier = Modifier
                    .testTag(
                        String.format(
                            TAG_STRING_EXPANDABLE_ITEM_Owner_NAME_LABEL, index
                        )
                    )
                    .padding(bottom = 10.dp)
            )

            Text(
                text = trendingGithubUiModel.description,
                modifier = Modifier.testTag(
                    String.format(
                        TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL, index
                    )
                ),
                style = MaterialTheme.typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

//            AnimatedVisibility(visible = isExpanded) {
//                ExpandableItem(trendingGithubUiModel = trendingGithubUiModel, index = index)
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrendingItemPreview() {
    VodafoneTaskTheme {
        TrendingItem(trendingGithubUiModel = trendingGithubUiModel,
            index = 1,
            onItemClicked = { _, _ ->
            }
        )
    }
}

//@Composable
//fun ExpandableItem(trendingGithubUiModel: TrendingGithubUiModel, index: Int) {
//    Column {
//        Text(
//            text = trendingGithubUiModel.description,
//            modifier = Modifier.testTag(
//                String.format(
//                    TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL, index
//                )
//            ),
//            style = MaterialTheme.typography.body2,
//            maxLines = 3,
//            overflow = TextOverflow.Ellipsis
//        )
//
//        Row(
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Box(
//                modifier = Modifier
//                    .testTag(
//                        String.format(
//                            TAG_STRING_EXPANDABLE_ITEM_CIRCLE_ICON, index
//                        )
//                    )
//                    .padding(end = 10.dp)
//                    .size(12.dp)
//                    .clip(RoundedCornerShape(24.dp))
//                    .background(Color.Blue)
//            )
//
//            Text(
//                text = trendingGithubUiModel.language,
//                modifier = Modifier
//                    .testTag(
//                        String.format(
//                            TAG_STRING_EXPANDABLE_ITEM_LANGUAGE_LABEL, index
//                        )
//                    )
//                    .padding(end = 5.dp)
//            )
//
//            Image(
//                painter = painterResource(id = R.drawable.ic_star),
//                contentDescription = "start icon",
//                colorFilter = ColorFilter.tint(Color.Yellow),
//                modifier = Modifier
//                    .testTag(
//                        String.format(
//                            TAG_STRING_EXPANDABLE_ITEM_STAR_ICON, index
//                        )
//                    )
//                    .size(30.dp)
//                    .padding(end = 5.dp)
//            )
//
//            Text(
//                text = trendingGithubUiModel.stars.toString(),
//                modifier = Modifier
//                    .testTag(
//                        String.format(
//                            TAG_STRING_EXPANDABLE_ITEM_STARS_NUMBER_LABEL, index
//                        )
//                    )
//                    .padding(end = 5.dp)
//            )
//        }
//    }
//}