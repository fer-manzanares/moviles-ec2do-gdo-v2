package mx.tcdmadero.ecnm.ec2dogradov2.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import mx.tcdmadero.ecnm.ec2dogradov2.model.Ecuacion2doGrado

class Ec2doGradoViewModel : ViewModel() {
    companion object {
        var equation : Ecuacion2doGrado? = null

        var coeficienteA by mutableStateOf("")
        var coeficienteB by mutableStateOf("")
        var coeficienteC by mutableStateOf("")
        var x1 by mutableStateOf("")
        var x2 by mutableStateOf("")
        var showResults by mutableStateOf(false)
        fun createEquation(){
            val a = coeficienteA.toFloat()
            val b = coeficienteB.toFloat()
            val c = coeficienteC.toFloat()

            equation = Ecuacion2doGrado(a, b, c)
        }

        fun resolveEquation(){
            if (equation != null) {
                x1 = equation!!.x1().toString()
                x2 = equation!!.x2().toString()
            }
        }

    }




}