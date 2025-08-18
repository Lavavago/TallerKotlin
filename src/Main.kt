

fun decimalABinario(n: Int): String {
    if (n < 2) return n.toString()
    return decimalABinario(n / 2) + (n % 2).toString()
}


fun binarioADecimal(bin: String): Int {
    if (bin.length == 1) return bin.toInt()
    val primer = bin[0].toString().toInt()
    val peso = 1 shl (bin.length - 1)
    return primer * peso + binarioADecimal(bin.substring(1))
}


fun main() {
    println("Conversor ")
    println("1 Decimal a Binario")
    println("2 Binario a Decimal")
    print("Elige una opción (1 o 2): ")

    val opcion = readLine()?.toIntOrNull()

    when (opcion) {
        1 -> {
            print("Introduce un número decimal: ")
            val numeroDecimal = readLine()?.toIntOrNull()
            if (numeroDecimal != null) {
                val binario = decimalABinario(numeroDecimal)
                println("Decimal $numeroDecimal  Binario $binario")
            } else {
                println("Entrada no válida.")
            }
        }
        2 -> {
            print("Introduce un número binario: ")
            val numeroBinario = readLine()
            if (numeroBinario != null && numeroBinario.all { it == '0' || it == '1' }) {
                val decimal = binarioADecimal(numeroBinario)
                println("Binario $numeroBinario Decimal $decimal")
            } else {
                println("Entrada no válida. Solo se permiten 0 y 1.")
            }
        }
        else -> {
            println("Opción no válida. Debes elegir 1 o 2.")
        }
    }
}


