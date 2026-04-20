package com.example.prototypevolunteerapp.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.prototypevolunteerapp.ui.screens.activities.ActivitiesScreen
import com.example.prototypevolunteerapp.ui.screens.activities.ActivityDetailScreen
import com.example.prototypevolunteerapp.ui.screens.dashboard.HomeScreen
import com.example.prototypevolunteerapp.ui.screens.history.ActivityHistoryScreen
import com.example.prototypevolunteerapp.ui.screens.notifications.NotificationsScreen
import com.example.prototypevolunteerapp.ui.screens.volunteers.VolunteerDetailScreen
import com.example.prototypevolunteerapp.ui.screens.volunteers.VolunteersScreen
import com.example.prototypevolunteerapp.ui.screens.welcome.WelcomeScreen
import com.example.prototypevolunteerapp.ui.theme.AksiKitaTheme

@Composable
fun ComposeApp() {
    val backStack = rememberNavBackStack(Routes.WelcomeRoute)
    CompositionLocalProvider(LocalBackStack provides backStack) {
        AksiKitaTheme {
            NavDisplay(
                backStack = backStack,
                entryDecorators = listOf(
                    // Menyimpan state composable saat navigasi
                    rememberSaveableStateHolderNavEntryDecorator(),
                    // Mengelola ViewModel per layar
                    rememberViewModelStoreNavEntryDecorator()
                ),
                entryProvider = entryProvider {
                    entry<Routes.WelcomeRoute> {WelcomeScreen()}
                    entry<Routes.HomeRoute> {HomeScreen()}
                    entry<Routes.ActivitiesRoute> {
                        ActivitiesScreen()
                    }
                    //it buat objek ActivityDetailRoute isinya berisi semua properti
                    entry<Routes.ActivityDetailRoute> {
                        ActivityDetailScreen(
                            title    = it.title,
                            location = it.location,
                            desc     = it.desc,
                            imageRes = it.imageRes,
                            instagram = it.instagram.ifBlank {null },
                            link     = it.link.ifBlank {null }
                        )
                    }

                    entry<Routes.VolunteersRoute> {
                        VolunteersScreen()
                    }

                    entry<Routes.VolunteerDetailRoute> {
                        VolunteerDetailScreen(
                            name     = it.name,
                            desc     = it.desc,
                            imageRes = it.imageRes,
                            phone    = it.phone.ifBlank { null },
                            email    = it.email.ifBlank { null }
                        )
                    }

                    entry<Routes.ActivityHistoryRoute> {
                        ActivityHistoryScreen()
                    }
                    entry<Routes.NotificationsRoute> {
                        NotificationsScreen()
                    }
                }
            )
        }
    }
}
