package net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation

import androidx.navigation3.runtime.entryProvider
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.HistoryScreen
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.MenuScreen
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.TrainScreen

fun appNavGraph(
    onNavigateToTrain: () -> Unit,
    onNavigateToHistory: () -> Unit,
    onNavigateBack: () -> Unit,
) = entryProvider {
    entry<MenuScreenDestination> {
        MenuScreen(
            onNavigateToTrain = onNavigateToTrain,
            onNavigateToHistory = onNavigateToHistory
        )
    }
    entry<TrainScreenDestination> {
        TrainScreen(
            onNavigateBack = onNavigateBack
        )
    }
    entry<HistoryScreenDestination> {
        HistoryScreen(
            onNavigateBack = onNavigateBack
        )
    }
}
