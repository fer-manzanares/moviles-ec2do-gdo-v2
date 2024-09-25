package mx.tcdmadero.ecnm.ec2dogradov2.view

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mx.tcdmadero.ecnm.ec2dogradov2.viewmodel.Ec2doGradoViewModel
import mx.tcdmadero.ecnm.ec2dogradov2.viewmodel.Ec2doGradoViewModel.Companion.showResults
import mx.tcdmadero.ecnm.ec2dogradov2.viewmodel.Ec2doGradoViewModel.Companion.x1
import mx.tcdmadero.ecnm.ec2dogradov2.viewmodel.Ec2doGradoViewModel.Companion.x2

@Composable
fun SolucionarEcuacion(modifier: Modifier, activity : Activity){

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Ecuaciones de 2do Grado")
        Spacer(modifier = Modifier.height(60.dp))
        Box {
            OutlinedTextField(value = Ec2doGradoViewModel.coeficienteA, onValueChange ={
                Ec2doGradoViewModel.coeficienteA = it
            }, label = { Text(text = "Coeficiente A:") } )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box {
            OutlinedTextField(value = Ec2doGradoViewModel.coeficienteB, onValueChange ={
                Ec2doGradoViewModel.coeficienteB = it
            }, label = { Text(text = "Coeficiente B:") } )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box {
            OutlinedTextField(value = Ec2doGradoViewModel.coeficienteC, onValueChange ={
                Ec2doGradoViewModel.coeficienteC = it
            }, label = { Text(text = "Coeficiente C:") } )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(onClick = {
                if (Ec2doGradoViewModel.coeficienteA == "" || Ec2doGradoViewModel.coeficienteB == "" || Ec2doGradoViewModel.coeficienteC == "" )
                {
                    Toast.makeText(activity, "Hacen falta datos", Toast.LENGTH_LONG).show()
                }else {
                    Ec2doGradoViewModel.createEquation()
                    Ec2doGradoViewModel.resolveEquation()
                    showResults = true
                }
            })
            {
                Text(text = "Raices")
                Icon(Icons.Rounded.ArrowForward, "")
            }
            Spacer(modifier = Modifier.width(20.dp))

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Gráfica")
            }
        }
        if (showResults){
            run {
                AlertDialog(

                    title = {
                        Text(text = "Solución de la ecuación")
                    },
                    text = {
                        Column {
                            Text(text = x1)
                            Text(text = x2)
                        }
                    },
                    onDismissRequest = {
                        showResults = false;
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showResults = false
                            }
                        ) {
                            Text("Confirm")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                showResults = false
                            }
                        ) {
                            Text("Dismiss")
                        }
                    }
                )
            }
        }
    }
}