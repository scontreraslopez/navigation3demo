package net.iessochoa.sergiocontreras.navigation3_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.navigation3_demo.ui.Navigation3DemoApp
import net.iessochoa.sergiocontreras.navigation3_demo.ui.theme.Navigation3demoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3demoTheme {
                Navigation3DemoApp()
            }
        }
    }
}
