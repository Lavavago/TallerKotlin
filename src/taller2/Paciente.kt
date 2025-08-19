package taller2

class Paciente(
    nombreCompleto: String,
    numeroIdentificacion: String,
    genero: String,
    correoElectronico: String,
    val telefono: String,
    val direccion: Direccion
) : Persona(nombreCompleto, numeroIdentificacion, genero, correoElectronico) {

    override fun toString(): String {
        return "Paciente(nombreCompleto='$nombreCompleto', identificacion='$numeroIdentificacion', genero='$genero', " +
                "correo='$correoElectronico', telefono='$telefono', direccion=$direccion)"
    }
}