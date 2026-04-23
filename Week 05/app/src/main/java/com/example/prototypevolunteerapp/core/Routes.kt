package com.example.prototypevolunteerapp.core

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
object Routes {
    @Serializable
    data object WelcomeRoute : NavKey

    @Serializable
    data class HomeRoute(val userName : String) : NavKey

    //Halaman tanpa parameter
    @Serializable
    data object ActivitiesRoute : NavKey

    // Halaman dengan parameter
    //Passing parameter: membawa data lengkap activity ke halaman detail
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
        val name: String,
        val desc: String,
        val imageRes: Int,
        val phone: String = "",
        val email: String = ""
    ) : NavKey

    @Serializable
    data object ActivityHistoryRoute : NavKey

    @Serializable
    data object NotificationsRoute : NavKey
}
