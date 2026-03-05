package net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.HistoryScreen
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.MenuScreen
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.TrainScreen

// el entryProvider { } (mapeo key->screen)

@Composable
fun EntryProviderDsl() {
    val backStack = remember { mutableStateListOf<AppDestination>(MenuScreenDestination) }
    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<MenuScreenDestination> {
                MenuScreen(
                    onNavigateToTrain = {  },
                    onNavigateToHistory = { }
                )
            }
            entry<TrainScreenDestination> {
                TrainScreen(
                    onNavigateBack = { }
                )

            }
            entry<HistoryScreenDestination> {
                HistoryScreen(
                    onNavigateBack = { }
                )

            }


            /*
            entry<ProductDetail>(
                metadata = mapOf("extraDataKey" to "extraDataValue")
            ) { key -> Text("Product ${key.id} ") }
            */

        }
    )
}