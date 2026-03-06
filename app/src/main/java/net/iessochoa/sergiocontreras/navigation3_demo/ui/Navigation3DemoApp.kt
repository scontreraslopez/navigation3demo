package net.iessochoa.sergiocontreras.navigation3_demo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.ui.NavDisplay
import net.iessochoa.sergiocontreras.navigation3_demo.R
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.AppDestination
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.HistoryScreenDestination
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.MenuScreenDestination
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.TrainScreenDestination
import net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation.appNavGraph
import net.iessochoa.sergiocontreras.navigation3_demo.ui.theme.Navigation3demoTheme

/**
 * La parte del TopAppBar es prácticamente igual que antes
 * Lo que cambia es que ahora usamos un NavDisplay en lugar de un NavHost,
 * y en lugar de NavController, ahora tenemos una backStack que es una lista mutable de destinos.
 * El orquestador de la navegación es ahora el NavDisplay, que se encarga de mostrar el destino que está al final de la backStack, y de gestionar las transiciones entre destinos.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation3DemoApp() {
    val backStack = remember { mutableStateListOf<AppDestination>(MenuScreenDestination) }
    val currentDestination = backStack.lastOrNull()

    val currentScreenTitle = when (currentDestination) {
        is MenuScreenDestination    -> "Menu"
        is TrainScreenDestination   -> "Entrenar"
        is HistoryScreenDestination -> "Historial"
        null -> "Pre-Flop Trainer"
    }

    val canNavigateBack = backStack.size > 1


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Navigation3DemoTopAppBar(
                title = currentScreenTitle,
                canNavigateBack = canNavigateBack,
                navigateUp = { backStack.removeLastOrNull() }
            )
        }
    ) { innerPadding ->
        //TODO: Ver que pasa con el innerPadding o los margenes
        NavDisplay(
            backStack = backStack,
            entryProvider = appNavGraph(
                onNavigateToTrain   = { backStack.add(TrainScreenDestination) },
                onNavigateToHistory = { backStack.add(HistoryScreenDestination) },
                onNavigateBack      = { backStack.removeLastOrNull() },
                modifier = Modifier.padding(innerPadding)
                )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation3DemoTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = null
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun Navigation3DemoAppPreview() {
    Navigation3demoTheme {
        Navigation3DemoApp()
    }
}
