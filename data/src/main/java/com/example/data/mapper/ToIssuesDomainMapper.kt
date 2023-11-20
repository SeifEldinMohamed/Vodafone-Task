package com.example.data.mapper

import com.example.data.data_sources.remote.dto.issues.IssuesDataModelItem
import com.example.data.formatDateString
import com.example.data.mapToIssueState
import com.example.domain.model.IssuesDomainModel

fun IssuesDataModelItem.toIssuesDomainModel(): IssuesDomainModel {
    return IssuesDomainModel(
        id = this.id,
        title = this.title,
        author = this.authorAssociation,
        date = formatDateString(this.createdAt),
        state = mapToIssueState(this.state) // didn't use valueOf bec of first capital letter
    )
}
