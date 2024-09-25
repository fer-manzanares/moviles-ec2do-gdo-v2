package mx.tcdmadero.ecnm.ec2dogradov2.model

import kotlin.math.sqrt

class Ecuacion2doGrado(val a : Float, val b : Float, val c : Float) {
    fun x1() : Float{
        return (-b + sqrt(b*b - 4F * a * c))/(2F * a)
    }
    fun x2() : Float{
        return (-b - sqrt(b*b - 4F * a * c))/(2F * a)
    }
}