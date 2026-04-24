package com.example.prototypevolunteerapp.core

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
object Routes {
    @Serializable
    data object WelcomeRoute : NavKey
    @Serializable
    data object HomeRoute : NavKey
    @Serializable
    data object LoginRoute : NavKey

    @Serializable
    data object ActivitiesRoute : NavKey

    @Serializable
    data class ActivityDetailRoute(
        val title: String,
        val location: String,
        val desc: String,
        val imageRes: Int,
        val instagram: String = "",
        val link: String = ""
    ) : NavKey

    @Serializable
    data object VolunteersRoute : NavKey

    @Serializable
    data class VolunteerDetailRoute(
        val volunteerIndex: Int  // index dari getDummyVolunteers()
    ) : NavKey

    @Serializable
    data object ActivityHistoryRoute : NavKey

    @Serializable
    data object NotificationsRoute : NavKey
}
