package taller2

class Medico(
    nombreCompleto: String,
    numeroIdentificacion: String,
    genero: String,
    correoElectronico: String,
    val numeroLicencia: String,
    val especialidad: String,
    val anioIngreso: Int,
    val salario: Double = 5000000.0 // Salario por defecto
) : Persona(nombreCompleto, numeroIdentificacion, genero, correoElectronico) {

    override fun toString(): String {
        return """
        --- Datos del Médico ---
        Nombre: $nombreCompleto
        ID: $numeroIdentificacion
        Género: $genero
        Correo: $correoElectronico
        Licencia: $numeroLicencia
        Especialidad: $especialidad
        Año de ingreso: $anioIngreso
        Salario: ${String.format("%,.2f", salario)} COP
        """.trimIndent()
    }
}