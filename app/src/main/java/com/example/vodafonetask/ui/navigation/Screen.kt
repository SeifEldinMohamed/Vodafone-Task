package com.example.vodafonetask.ui.navigation

import com.example.presentation.utils.Constants.Companion.DETAILS_SCREEN
import com.example.presentation.utils.Constants.Companion.HOME_SCREEN
import com.example.presentation.utils.Constants.Companion.ISSUES_SCREEN
import com.example.presentation.utils.Constants.Companion.NAME_ARGUMENT_KEY
import com.example.presentation.utils.Constants.Companion.OWNER_ARGUMENT_KEY

sealed class Screen(val route: String) {
    data object Home : Screen(route = HOME_SCREEN)
    data object Details : Screen(route = "$DETAILS_SCREEN/{$OWNER_ARGUMENT_KEY}/{$NAME_ARGUMENT_KEY}"){
        fun passOwnerAndName(owner: String, name:String): String {
            return "$DETAILS_SCREEN/$owner/$name"
        }
    }

    data object Issues : Screen(route = "$ISSUES_SCREEN/{$OWNER_ARGUMENT_KEY}/{$NAME_ARGUMENT_KEY}"){
        fun passOwnerAndName(owner: String, name:String): String {
            return "$ISSUES_SCREEN/$owner/$name"
        }
    }
}