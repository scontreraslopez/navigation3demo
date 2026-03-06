package net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.HistoryScreen
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.MenuScreen
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.TrainScreen

/** Esto si que es nuevo, aunque conceptualmente muy parecido.
 * En lugar del NavHost y los composables, ahora tenemos un entryProvider, que es una función que devuelve un mapa de destinos a composables.
 * Es decir, es una función que nos permite registrar los destinos de nuestra app y asociarlos a composables concretos.
 *
 */

fun appNavGraph(
    onNavigateToTrain: () -> Unit,
    onNavigateToHistory: () -> Unit,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) = entryProvider {
    entry<MenuScreenDestination> {
        MenuScreen(
            onNavigateToTrain = onNavigateToTrain,
            onNavigateToHistory = onNavigateToHistory,
            modifier = modifier
        )
    }
    entry<TrainScreenDestination> {
        TrainScreen(
            onNavigateBack = onNavigateBack,
            modifier = modifier
        )
    }
    entry<HistoryScreenDestination> {
        HistoryScreen(
            onNavigateBack = onNavigateBack,
            modifier = modifier
        )
    }
}
