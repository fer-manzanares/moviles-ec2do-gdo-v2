package mx.tcdmadero.ecnm.ec2dogradov2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import mx.tcdmadero.ecnm.ec2dogradov2.ui.theme.Ec2doGradoV2Theme
import mx.tcdmadero.ecnm.ec2dogradov2.view.SolucionarEcuacion

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ec2doGradoV2Theme {
                   SolucionarEcuacion(
                        Modifier.fillMaxSize(),
                       this
                    )
            }
        }
    }
}
