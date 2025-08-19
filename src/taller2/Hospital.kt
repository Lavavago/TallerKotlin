package taller2

import java.time.Year

class Hospital(
    val nombre: String,
    val nit: String,
    val direccion: Direccion
) {
    // Uso de listas como en tu código original para seguir la guía
    private val medicos = mutableListOf<Medico>()
    private val pacientes = mutableListOf<Paciente>()

    // CRUD para Médicos
    fun agregarMedico(medico: Medico) = medicos.add(medico).also { println("Médico ${medico.nombreCompleto} agregado.") }
    fun obtenerMedico(id: String): Medico? = medicos.find { it.numeroIdentificacion == id }
    fun actualizarMedico(id: String, nuevoMedico: Medico) {
        val index = medicos.indexOfFirst { it.numeroIdentificacion == id }
        if (index != -1) medicos[index] = nuevoMedico.also { println("Médico actualizado.") }
        else println("Médico no encontrado para actualizar.")
    }
    fun eliminarMedico(id: String) {
        if (medicos.removeIf { it.numeroIdentificacion == id }) {
            println("Médico eliminado.")
        } else {
            println("Médico no encontrado para eliminar.")
        }
    }

    // CRUD para Pacientes
    fun agregarPaciente(paciente: Paciente) = pacientes.add(paciente).also { println("Paciente ${paciente.nombreCompleto} agregado.") }
    fun obtenerPaciente(id: String): Paciente? = pacientes.find { it.numeroIdentificacion == id }
    fun actualizarPaciente(id: String, nuevoPaciente: Paciente) {
        val index = pacientes.indexOfFirst { it.numeroIdentificacion == id }
        if (index != -1) pacientes[index] = nuevoPaciente.also { println("Paciente actualizado.") }
        else println("Paciente no encontrado para actualizar.")
    }
    fun eliminarPaciente(id: String) {
        if (pacientes.removeIf { it.numeroIdentificacion == id }) {
            println("Paciente eliminado.")
        } else {
            println("Paciente no encontrado para eliminar.")
        }
    }

    // Funcionalidades de cálculo
    fun calcularSalarioTotal(): Double {
        val salariosPorEspecialidad = mapOf(
            "Cardiología" to 5000000.0,
            "Pediatría" to 4500000.0,
            "Medicina General" to 3000000.0,
            "Dermatología" to 4000000.0
        )
        return medicos.sumOf { salariosPorEspecialidad.getOrDefault(it.especialidad, 3000000.0) }
    }

    fun calcularSalarioPorEspecialidad(): Map<String, Double> {
        val salariosPorEspecialidad = mapOf(
            "Cardiología" to 5000000.0,
            "Pediatría" to 4500000.0,
            "Medicina General" to 3000000.0,
            "Dermatología" to 4000000.0
        )
        return medicos.groupBy { it.especialidad }
            .mapValues { (_, medicos) ->
                medicos.sumOf { salariosPorEspecialidad.getOrDefault(it.especialidad, 3000000.0) }
            }
    }

    fun obtenerPorcentajePacientesPorGenero(): Map<String, String> {
        val totalPacientes = pacientes.size.toDouble()
        if (totalPacientes == 0.0) return emptyMap()

        return pacientes.groupingBy { it.genero }
            .eachCount()
            .mapValues { (_, count) ->
                String.format("%.2f%%", (count / totalPacientes) * 100)
            }
    }

    fun obtenerCantidadMedicosPorEspecialidad(): Map<String, Int> {
        return medicos.groupingBy { it.especialidad }.eachCount()
    }

    fun obtenerMedicoMasAntiguo(): Medico? {
        val anioActual = Year.now().value
        return medicos.minByOrNull { anioActual - it.anioIngreso }
    }
}