package net.iessochoa.sergiocontreras.navigation3_demo.ui.navigation

// sealed interface con todas las keys

/**
 * Esto es similar a lo que hacíamos antes
 */

sealed interface AppDestination

data object MenuScreenDestination: AppDestination
data object HistoryScreenDestination: AppDestination
data object TrainScreenDestination: AppDestination

//data class ProductDetail(val id: String): AppDestination

