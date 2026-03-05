package net.iessochoa.sergiocontreras.navigation3_demo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HistoryScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Historial")
        Text("Precision: 7 / 10 (70%)")

        HorizontalDivider()

        HistoryRow("A♠K♥", "BTN", "RAISE", correcto = true)
        HistoryRow("7♦2♣", "UTG", "FOLD",  correcto = true)
        HistoryRow("Q♠J♥", "CO",  "CALL",  correcto = false)
        HistoryRow("3♣2♠", "SB",  "FOLD",  correcto = true)

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(onClick = onNavigateBack, modifier = Modifier.fillMaxWidth()) {
            Text("Volver")
        }
    }
}

@Composable
private fun HistoryRow(cartas: String, posicion: String, accion: String, correcto: Boolean) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("$cartas  $posicion")
        Text("$accion  ${if (correcto) "V" else "X"}")
    }
}

@Preview(showBackground = true)
@Composable
private fun HistoryScreenPreview() {
    HistoryScreen(onNavigateBack = {})
}
