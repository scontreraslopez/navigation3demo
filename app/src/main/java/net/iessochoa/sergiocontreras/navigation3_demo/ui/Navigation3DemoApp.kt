package net.iessochoa.sergiocontreras.navigation3_demo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.ui.NavDisplay
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.AppDestination
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.HistoryScreenDestination
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.MenuScreenDestination
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.TrainScreenDestination
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.appNavGraph
import net.iessochoa.sergiocontreras.navigation3_demo.ui.theme.Navigation3demoTheme

@Composable
fun Navigation3DemoApp() {
    val backStack = remember { mutableStateListOf<AppDestination>(MenuScreenDestination) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding),
            entryProvider = appNavGraph(
                onNavigateToTrain   = { backStack.add(TrainScreenDestination) },
                onNavigateToHistory = { backStack.add(HistoryScreenDestination) },
                onNavigateBack      = { backStack.removeLastOrNull() }
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Navigation3DemoAppPreview() {
    Navigation3demoTheme {
        Navigation3DemoApp()
    }
}
