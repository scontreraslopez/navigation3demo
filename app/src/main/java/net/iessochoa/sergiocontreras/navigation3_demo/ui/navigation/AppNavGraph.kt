package net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.HistoryScreen
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.MenuScreen
import net.iessochoa.sergiocontreras.navigation3_demo.ui.screens.TrainScreen

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
