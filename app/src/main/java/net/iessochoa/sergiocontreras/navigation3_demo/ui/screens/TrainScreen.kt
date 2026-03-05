package net.iessochoa.sergiocontreras.navigation3_demo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TrainScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Posicion: BTN")

        Text("A♠  K♥", fontSize = 48.sp)

        Text("Que harias?")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {}) { Text("Fold") }
            Button(onClick = {}) { Text("Call") }
            Button(onClick = {}) { Text("Raise") }
        }

        Text("Correcto! La jugada era RAISE")

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(onClick = onNavigateBack, modifier = Modifier.fillMaxWidth()) {
            Text("Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TrainScreenPreview() {
    TrainScreen(onNavigateBack = {})
}
