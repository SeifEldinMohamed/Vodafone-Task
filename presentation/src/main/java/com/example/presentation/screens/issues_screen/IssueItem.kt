package com.example.presentation.screens.issues_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.model.IssuesUiModel
import com.example.presentation.screens.issues_screen.preview.issuesUiModelPreviewData
import com.example.presentation.theme.VodafoneTaskTheme
import com.example.presentation.utils.Locators.TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_ISSUE_AUTHOR_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_ISSUE_IMAGE
import com.example.presentation.utils.Locators.TAG_STRING_ISSUE_STATE_LABEL
import com.example.presentation.utils.Locators.TAG_STRING_ISSUE_TITLE_LABEL

@Composable
fun IssueItem(
    issuesUiModel: IssuesUiModel,
    index: Int,
) {
    val createdAtAnnotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(stringResource(R.string.issue_created_at))
        }
        append(issuesUiModel.date.substringAfter(stringResource(R.string.column)))
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_issues),
            contentDescription = "issue icom",
            modifier = Modifier
                .testTag(
                    String.format(
                        TAG_STRING_ISSUE_IMAGE, index
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
                    text = issuesUiModel.title,
                    modifier = Modifier
                        .testTag(
                            String.format(
                                TAG_STRING_ISSUE_TITLE_LABEL, index
                            )
                        )
                        .padding(bottom = 6.dp)
                        .weight(4f),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = issuesUiModel.state.name,
                    modifier = Modifier
                        .testTag(
                            String.format(
                                TAG_STRING_ISSUE_STATE_LABEL, index
                            )
                        )
                        .padding(end = 5.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = issuesUiModel.author,
                modifier = Modifier
                    .testTag(
                        String.format(
                            TAG_STRING_ISSUE_AUTHOR_LABEL, index
                        )
                    )
                    .padding(bottom = 10.dp),
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = createdAtAnnotatedString,
                modifier = Modifier.testTag(
                    String.format(
                        TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL, index
                    )
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrendingItemPreview() {
    VodafoneTaskTheme {
        IssueItem(
            issuesUiModel = issuesUiModelPreviewData,
            index = 1,
        )
    }
}